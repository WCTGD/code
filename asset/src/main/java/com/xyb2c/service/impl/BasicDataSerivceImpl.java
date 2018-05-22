package com.xyb2c.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.AssetsMapper;
import com.xyb2c.dao.BaseAssetClassMapper;
import com.xyb2c.dao.BaseContractorMapper;
import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.dao.SundryAssetsStateMapper;
import com.xyb2c.dao.SundryAssetsWayMapper;
import com.xyb2c.dao.SundryJobClassMapper;
import com.xyb2c.dao.SundryJobPriorityMapper;
import com.xyb2c.dao.SundryUrgencyLevelMapper;
import com.xyb2c.dao.SundryWokerorderClassMapper;
import com.xyb2c.dao.SundryWokerorderStateMapper;
import com.xyb2c.dao.SundryWorkerClassMapper;
import com.xyb2c.dao.SupplierMapper;
import com.xyb2c.dao.UploadFileMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.SundryJobPriority;
import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.UploadFile;
import com.xyb2c.service.BasicDataService;
import com.xyb2c.util.position.PositionJudge;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
@Service("basicDataService")
public class BasicDataSerivceImpl implements BasicDataService {
	@Autowired
	BaseDepartmentMapper bMapper;

	@Autowired
	AssetsMapper aMapper;

	@Autowired
	WorkerMapper workerMapper;

	@Autowired
	BaseAssetClassMapper baMapper;

	@Autowired
	SupplierMapper supplierMapper;

	@Autowired
	BaseContractorMapper baserContractorMapper;

	@Autowired
	SundryWokerorderStateMapper swsMapper;

	@Autowired
	SundryWokerorderClassMapper swcMapper;

	@Autowired
	SundryAssetsStateMapper sasMapper;

	@Autowired
	PositionMapper positionMapper;

	@Autowired
	SundryAssetsWayMapper sundryAssetsWayMapper;

	@Autowired
	SundryWorkerClassMapper sundryWokerClassMapper;

	@Autowired
	SundryUrgencyLevelMapper sundryUrgencyLevelMapper;

	@Autowired
	SundryJobPriorityMapper sundryJobPriorityMapper;

	@Autowired
	SundryJobClassMapper sundryJobClassMapper;

	@Autowired
	UploadFileMapper fileMapper;

	@Autowired
	RecycleMapper recycleMapper;

	@Override
	public List<BaseDepartment> baseDepartmentSelect(PageBean page) {
		page.setTotalRecord(bMapper.countBaseDepartment()); // 部门总数 count
		return bMapper.baseDepartmentSelect(page);
	}

	// @Override
	// public void insertBaseDepartment(BaseDepartment bDepartment) {
	// bMapper.insertBaseDepartment(bDepartment);
	// }

	// @Override
	// public BaseDepartment selectBaseDepartmentById(Integer id) {
	// return bMapper.selectBaseDepartmentById(id);
	// }

	// @Override
	// public void updateBaseDepartment(BaseDepartment bDepartment) {
	// bMapper.updateBaseDepartment(bDepartment);
	// }

	@Override
	public List<Assets> assetsSelect(PageBean page) {
		page.setTotalRecord(aMapper.countAssets());
		return aMapper.assetsSelect(page);
	}

	@Override
	public List<BaseAssetClass> assetClasseSelect(PageBean page) {
		page.setTotalRecord(baMapper.counttBaseAssetClass());
		return baMapper.baseAssetClasseSelect(page);
	}

	@Override
	public List<Supplier> supplierSelect(PageBean page) {
		page.setTotalRecord(supplierMapper.countSupplier());
		return supplierMapper.supplierSelect(page);
	}

	@Override
	public List<BaseContractor> baseContractorSelect(PageBean page) {
		page.setTotalRecord(baserContractorMapper.countBaseContractor());
		return baserContractorMapper.baseContractorSelect(page);
	}

	@Override
	public List<SundryWokerorderState> sundryWokerorderStatesSelect() {
		return swsMapper.sundryWokerorderStatesSelect();
	}

	@Override
	public List<SundryWokerorderClass> selectSundryWokerorderClass() {
		return swcMapper.selectSundryWokerorderClass();
	}

	@SuppressWarnings("null")
	@Override
	public String departmentJudge(String departmen, String no) {
		List<BaseDepartment> list = bMapper.selectDepartment();
		Map<String, Object> map = new HashMap<>();
		for (BaseDepartment baseDepartment : list) {
			map.put(baseDepartment.getNo(), baseDepartment.getDepartment());
		}
		if (departmen == null && !departmen.equals("") && no == null && !no.equals("")) {
			return "1";
		}
		if (map.containsKey(no)) {
			return "1";
		}
		if (map.containsValue(departmen)) {
			return "1";
		}
		return "2";
	}

	// @Override
	// public int deleteDepartment(String no) {
	// if(no != null &&! no.equals("")){
	// if(judgePosition(no) == 1 && judgeAssets(no) == 1){
	// bMapper.deleteDepartment(no);
	// return 1;
	// }
	// return 2;
	// }
	// return 3;
	// }

	// 删除资产判断（部门）
	public int judgeAssets(String no) {
		BaseDepartment bd = bMapper.selectDepartmentByNo(no); // 获取id
		List<Assets> assets = aMapper.selectAssets(); // 获取所有的资产
		Map<String, Object> map = new HashMap<>();
		assets.forEach(list -> map.put(list.getDepartmentNo(), list.getDepartmentId()));
		if (map.containsValue(bd.getId())) {
			return 2;
		}
		return 1;
	}

	// 删除位置判断 （部门）
	public int judgePosition(String no) {
		BaseDepartment bd = bMapper.selectDepartmentByNo(no); // 获取id
		List<Position> positions = positionMapper.selectPosition(); // 获取位置所有信息
		Map<String, Object> map = new HashMap<>();
		for (Position list : positions) {
			map.put(list.getNo(), list.getdId());
		}
		if (map.containsValue(bd.getId())) {
			return 2;
		}
		return 1;
	}

	@Override
	public void deleteAssetsByNo(String no) {
		if (no != null && !no.equals("")) {
			aMapper.deleteAssetsByNo(no);
		}
	}

	// @Override
	// public void deleteWorkerByNo(String no) {
	// if(no != null &&! no.equals("")){
	// workerMapper.deleteWorkerByNo(no);
	// }
	// }

	@Override
	public int deletePositionByNo(String no) {
		if (no != null && !no.equals("")) {
			Position position = positionMapper.selectPositionByNo(no); // 获取到需要的id
			if (delectJudge(position.getId()) == 2) {
				positionMapper.deletePositionByNo(no);
				return 1;
			}
			return 2;
		}
		return 0;
	}

	public int delectJudge(Integer id) {
		List<Assets> list = aMapper.selectAssets();
		Map<String, Object> map = new HashMap<>();
		list.forEach(assets -> map.put(assets.getPositionNo(), assets.getPositionId()));
		if (map.containsValue(id)) {
			return 1;
		}
		return 2;
	}

	@Override
	public List<BaseAssetClass> selectBaseAssetClass() {
		return baMapper.selectBaseAssetClass();
	}

	@Override
	public List<SundryAssetsState> selectSundryAssetsState() {
		return sasMapper.selectSundryAssetsState();
	}

	@Override
	public List<SundryAssetsWay> selectSundryAssetsWay() {
		return sundryAssetsWayMapper.selectSundryAssetsWay();
	}

	@Override
	public List<SundryWorkerClass> selectSundryWokerClass() {
		return sundryWokerClassMapper.selectSundryWokerClass();
	}

	@Override
	public List<SundryUrgencyLevel> selectSundryUrgencyLevel() {
		return sundryUrgencyLevelMapper.selectSundryUrgencyLevel();
	}

	@Override
	public List<SundryJobPriority> selectSundryJobPriority() {
		return sundryJobPriorityMapper.selectSundryJobPriority();
	}

	@Override
	public void sundryWokerorderStatesInsert(SundryWokerorderState sundryWokerorderState) {
		if (sundryWokerorderState.getInformation() != null && !sundryWokerorderState.getInformation().equals("")) {
			swsMapper.sundryWokerorderStatesInsert(sundryWokerorderState);
		}
	}

	@Override
	public String sundryWokerorderStatesDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				swsMapper.sundryWokerorderStatesDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public void sundryWokerorderClassInsert(SundryWokerorderClass sundryWokerorderClass) {
		if (sundryWokerorderClass.getInformation() != null && !sundryWokerorderClass.getInformation().equals("")) {
			swcMapper.sundryWokerorderClassInsert(sundryWokerorderClass);
		}
	}

	@Override
	public String sundryWokerorderClassDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				swcMapper.sundryWokerorderClassDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public void sundryAssetsStateInsert(SundryAssetsState sundryAssetsState) {
		if (sundryAssetsState.getInformation() != null && !sundryAssetsState.getInformation().equals("")) {
			sasMapper.sundryAssetsStateInsert(sundryAssetsState);
		}
	}

	@Override
	public String sundryAssetsStateDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				sasMapper.sundryAssetsStateDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public void sundryAssetsWayInsert(SundryAssetsWay sundryAssetsWay) {
		if (sundryAssetsWay.getInformation() != null && !sundryAssetsWay.getInformation().equals("")) {
			sundryAssetsWayMapper.sundryAssetsWayInsert(sundryAssetsWay);
		}
	}

	@Override
	public String sundryAssetsWayDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				sundryAssetsWayMapper.sundryAssetsWayDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public void sundryJobPriorityInsert(SundryJobPriority sundryJobPriority) {
		if (sundryJobPriority.getInformation() != null && !sundryJobPriority.getInformation().equals("")) {
			sundryJobPriorityMapper.sundryJobPriorityInsert(sundryJobPriority);
		}
	}

	@Override
	public String sundryJobPriorityDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				sundryJobPriorityMapper.sundryJobPriorityDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public void sundryUrgencyLevelInsert(SundryJobClass sundryJobClass) {
		if (sundryJobClass.getInformation() != null && !sundryJobClass.getInformation().equals("")) {
			sundryJobClassMapper.sundryJobClassInsert(sundryJobClass);
		}
	}

	@Override
	public int sundryUrgencyLevelDelete(String information) {
		if (information != null && !information.equals("")) {
			sundryJobClassMapper.sundryJobClassDelete(information);
			return 1;
		}
		return 0;
	}

	@Override
	public void sundryWokerClassInsert(SundryWorkerClass sundryWokerClass) {
		if (sundryWokerClass.getInformation() != null && !sundryWokerClass.getInformation().equals("")) {
			sundryWokerClassMapper.sundryWokerClassInsert(sundryWokerClass);
		}
	}

	@Override
	public String sundryWokerClassDelete(String information) {
		try {
			if (information != null && !information.equals("")) {
				sundryWokerClassMapper.sundryWokerClassDelete(information);
			}
		} catch (Exception e) {
			return "1";
		}
		return "2";
	}

	@Override
	public int judgeSundryWokerorderState(SundryWokerorderState sundryWokerorderState) {
		List<SundryWokerorderState> list = swsMapper.sundryWokerorderStatesSelect(); // 获取所有数据库的工单状态
		Map<String, Object> map = new HashMap<>();
		for (SundryWokerorderState sws : list) {
			map.put(sws.getInformation(), sws.getInformation());
		}
		if (map.containsKey(sundryWokerorderState.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryWokerorderClass(SundryWokerorderClass sundryWokerorderClass) {
		List<SundryWokerorderClass> list = swcMapper.selectSundryWokerorderClass(); // 获取所有数据库的工单类型
		Map<String, Object> map = new HashMap<>();
		for (SundryWokerorderClass swc : list) {
			map.put(swc.getInformation(), swc.getInformation());
		}
		if (map.containsKey(sundryWokerorderClass.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryAssetsState(SundryAssetsState sundryAssetsState) {
		List<SundryAssetsState> list = sasMapper.selectSundryAssetsState(); // 获取所有数据库de
																			// 数据
		Map<String, Object> map = new HashMap<>();
		for (SundryAssetsState sas : list) {
			map.put(sas.getInformation(), sas.getInformation());
		}
		if (map.containsKey(sundryAssetsState.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryAssetsWay(SundryAssetsWay sundryAssetsWay) {
		List<SundryAssetsWay> list = sundryAssetsWayMapper.selectSundryAssetsWay(); // 获取所有数据库de
																					// 数据
		Map<String, Object> map = new HashMap<>();
		for (SundryAssetsWay sas : list) {
			map.put(sas.getInformation(), sas.getInformation());
		}
		if (map.containsKey(sundryAssetsWay.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryWorkerClass(SundryWorkerClass sundryWorkerClass) {

		List<SundryWorkerClass> list = sundryWokerClassMapper.selectSundryWokerClass(); // 获取所有数据库de
																						// 数据
		Map<String, Object> map = new HashMap<>();
		for (SundryWorkerClass sas : list) {
			map.put(sas.getInformation(), sas.getInformation());
		}
		if (map.containsKey(sundryWorkerClass.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryUrgencyLevel(SundryJobClass sundryUrgencyLevel) {
		List<SundryJobClass> list = sundryJobClassMapper.selectSundryJobClass();
		Map<String, Object> map = new HashMap<>();
		// for(SundryJobClass sas : list){
		// map.put(sas.getInformation(), sas.getInformation());
		// }
		list.forEach(sas -> map.put(sas.getInformation(), sas.getInformation()));
		if (map.containsKey(sundryUrgencyLevel.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public int judgeSundryJobPriority(SundryJobPriority sundryJobPriority) {
		List<SundryJobPriority> list = sundryJobPriorityMapper.selectSundryJobPriority();
		Map<String, Object> map = new HashMap<>();
		for (SundryJobPriority sas : list) {
			map.put(sas.getInformation(), sas.getInformation());
		}
		if (map.containsKey(sundryJobPriority.getInformation())) {
			return 1;
		}
		return 2;
	}

	@Override
	public void saveAssetClasses(BaseAssetClass baseAssetClass) {
		if (judge(baseAssetClass) == 1) {
			baMapper.saveAssetClasses(baseAssetClass);
		}
	}

	@Override
	public int judgeBaseAssetClass(BaseAssetClass baseAssetClass) {
		List<BaseAssetClass> list = baMapper.selectBaseAssetClass();
		Map<String, Object> map = new HashMap<>();
		list.forEach(sas -> map.put(sas.getAssetCategory(), sas.getAssetCategory()));
		// for(BaseAssetClass sas : list){
		// map.put(sas.getAssetCategory(), sas.getNo());
		// }
		if (map.containsKey(baseAssetClass.getAssetCategory())) {
			return 1;
		}
		return 2;
	}

	/**
	 * 资产类别添加非空判断
	 * 
	 * @param baseAssetClass
	 * @return
	 */
	public int judge(BaseAssetClass baseAssetClass) {
		if (baseAssetClass.getAssetCategory() != null && !baseAssetClass.getAssetCategory().equals("")) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteAssetClasses(String deleteAssetClasses) {
		if (deleteAssetClasses != null && !deleteAssetClasses.equals("")) {
			baMapper.deleteAssetClasses(deleteAssetClasses);
			return 1;
		}
		return 2;
	}

	@Override
	public Supplier supplierSelectByNo(String no) {
		return supplierMapper.supplierSelectByNo(no);
	}

	@Override
	public int supplierDeleteByNo(String no,String name) {
		Supplier supplier = supplierMapper.supplierSelectByNo(no); // 获取Id
		List<Assets> list = aMapper.selectAssets(); // 获取所有 资产信息
		Map<Object, Object> map = new HashMap<>();
		list.forEach(asset -> map.put(asset.getSupplierId(), asset.getSupplierId()));
		// for(Assets asset : list){
		// map.put(asset.getSupplierId(),asset.getSupplierId());
		// }
		if (no != null && !no.equals("")) {
			if (map.containsValue(supplier.getId())) {
				return 0;
			}
			Recycle r=new Recycle();
			r.setOperation(name);
			r.setTbName("supplier");
			r.setFkId(supplier.getId());
			r.setType("供应商");
			recycleMapper.insert(r);
			supplierMapper.supplierDeleteByNo(no);
			return 3;
		}
		return 4;
	}

	@Override
	public Supplier stitchingNumber() {
		Supplier supplier = supplierMapper.supplierAdd();
		if (supplier.getNo() == null || supplier.getNo().equals("")) {
			supplier.setNo("001");
		} else {
			if (Integer.parseInt(supplier.getNo()) < 9 && Integer.parseInt(supplier.getNo()) > 0) {
				Integer integer = Integer.parseInt(supplier.getNo()) + 1;
				supplier.setNo("00" + integer);
			}
			if (Integer.parseInt(supplier.getNo()) < 99 && Integer.parseInt(supplier.getNo()) > 8) {
				Integer integer = Integer.parseInt(supplier.getNo()) + 1;

				supplier.setNo("0" + integer);
			}
			if (Integer.parseInt(supplier.getNo()) > 98) {
				Integer integer = Integer.parseInt(supplier.getNo()) + 1;
				supplier.setNo("" + integer);
			}
		}
		return supplier;
	}

	@Override
	public void supplierInsert(Supplier supplier) {
		supplierMapper.supplierInsert(supplier);
	}

	@Override
	public void updateSupplierByNo(Supplier supplier) {
		supplierMapper.updateSupplierByNo(supplier);
	}

	@Override
	public BaseContractor baseContractorSelectByNo(BaseContractor baseContractor) {
		return baserContractorMapper.baseContractorSelectByNo(baseContractor);
	}

	@Override
	public List<SundryJobClass> selectSundryJobClass() {
		return sundryJobClassMapper.selectSundryJobClass();
	}

	@Override
	public int deleteBaseContractorByNo(String no, String name) {
		if (no != null && !no.equals("")) {
			BaseContractor bc = new BaseContractor();
			bc.setNo(no);
			List<Assets> list = aMapper.selectAssets(); // 获取所有 资产信息
			BaseContractor baseContractor = baserContractorMapper.baseContractorSelectByNo(bc); // 获取id
			Map<Object, Object> map = new HashMap<>();
			list.forEach(baseC -> map.put(baseC.getContractorId(), baseC.getContractorId()));
			if (map.containsValue(baseContractor.getId())) {
				return 0;
			}
			baserContractorMapper.deleteBaseContractorByNo(no);
			Recycle r = new Recycle();
			r.setOperation(name);
			r.setTbName("base_contractor");
			r.setFkId(baseContractor.getId());
			r.setType("承包商");
			recycleMapper.insert(r);
			return 1;
		}
		return 3;
	}

	@Override
	public BaseContractor contractorNumber() {
		BaseContractor baseContractor = baserContractorMapper.baseContractorAdd();
		if (baseContractor.getNo() == null || baseContractor.getNo().equals("")) {
			baseContractor.setNo("001");
		} else {
			if (Integer.parseInt(baseContractor.getNo()) < 9 && Integer.parseInt(baseContractor.getNo()) > 0) {
				Integer integer = Integer.parseInt(baseContractor.getNo()) + 1;
				baseContractor.setNo("00" + integer);
			}
			if (Integer.parseInt(baseContractor.getNo()) < 99 && Integer.parseInt(baseContractor.getNo()) > 8) {
				Integer integer = Integer.parseInt(baseContractor.getNo()) + 1;

				baseContractor.setNo("0" + integer);
			}
			if (Integer.parseInt(baseContractor.getNo()) > 98) {
				Integer integer = Integer.parseInt(baseContractor.getNo()) + 1;
				baseContractor.setNo("" + integer);
			}
		}
		return baseContractor;
	}

	@Override
	public void baseContractorInsert(BaseContractor baseContractor) {
		baserContractorMapper.baseContractorInsert(baseContractor);
	}

	@Override
	public void updateBaseContractorByNo(BaseContractor baseContractor) {
		if (PositionJudge.updateBaserContractorJudge(baseContractor) == 2) {
			baserContractorMapper.updateBaseContractorByNo(baseContractor);
		}
	}

	@Override
	public int SecurityGuidance(String name, String url) {
		List<UploadFile> uploadFiles = fileMapper.uploadFileList(); // 查询所有数据
		if (name == null || name.equals("") || url == null || url.equals("")) {
			return 0;
		}
		UploadFile uploadFile = new UploadFile();
		uploadFile.setName(name);
		uploadFile.setNo(uploadFileNo());
		uploadFile.setUrl(url);
		Map<Object, Object> map = new HashMap<>();
		// uploadFiles.forEach(uf->map.put(uf.getName(), uf.getName()));
		// map.forEach((k,v)->System.out.println(k.toString()+v));
		for (UploadFile file : uploadFiles) {
			map.put(file.getName(), file.getName());
		}
		if (map.containsKey(name)) {
			fileMapper.updateUploadFile(uploadFile);
		} else {
			fileMapper.insertUploadFile(uploadFile);
		}
		return 1;
	}

	// no
	public String uploadFileNo() {
		UploadFile uploadFile = fileMapper.uploadFileNo();
		if (uploadFile == null) {
			uploadFile = new UploadFile();
			uploadFile.setNo("001");
		} else {
			if (Integer.parseInt(uploadFile.getNo()) < 9 && Integer.parseInt(uploadFile.getNo()) > 0) {
				Integer integer = Integer.parseInt(uploadFile.getNo()) + 1;
				uploadFile.setNo("00" + integer);
			}
			if (Integer.parseInt(uploadFile.getNo()) < 99 && Integer.parseInt(uploadFile.getNo()) > 8) {
				Integer integer = Integer.parseInt(uploadFile.getNo()) + 1;
				uploadFile.setNo("0" + integer);
			}
			if (Integer.parseInt(uploadFile.getNo()) > 98) {
				Integer integer = Integer.parseInt(uploadFile.getNo()) + 1;
				uploadFile.setNo("" + integer);
			}
		}
		return uploadFile.getNo();
	}

	@Override
	public List<UploadFile> listUploadFile(PageBean page) {
		page.setTotalRecord(fileMapper.countUploadFile());
		return fileMapper.listUploadFile(page);
	}

	@Override
	public void deleteSecurityGuidance(String no) {
		if (no != null && !no.equals("")) {
			fileMapper.deleteSecurityGuidance(no);
		}
	}

	@Override
	public UploadFile downloadUploadFile(String no) {
		return fileMapper.downloadUploadFile(no);
	}
}
