package com.xyb2c.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.SundryJobPriority;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.UploadFile;
import com.xyb2c.pojo.User;
import com.xyb2c.service.BasicDataService;
import com.xyb2c.util.position.PositionJudge;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
@Controller
@RequestMapping(value = "basicData")
public class BasicDataController {
	@Autowired
	BasicDataService basicDataService;

	/**
	 * 基础信息 部门查询
	 * 
	 * @param maps
	 *            分页
	 * @return
	 */
	@RequestMapping(value = "/basicDataList")
	@ResponseBody
	public Map<String, Object> basicDataList(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<BaseDepartment> bDepartment = basicDataService.baseDepartmentSelect(page);
		Map<String, Object> map = new HashMap<>();
		map.put("list", bDepartment);
		map.put("page", page);
		return map;
	}

	/**
	 * 添加部门
	 * 
	 * @param bDepartment
	 * @return
	 */
//	@RequestMapping(value = "/saveDepartment")
//	@ResponseBody
//	public Map<String, Object> saveDepartment(@RequestBody BaseDepartment bDepartment) {
//		Map<String, Object> map = new HashMap<>();
//		if (PositionJudge.insterDepartmentJudge(bDepartment) != 1) {
//			String judge = basicDataService.departmentJudge(bDepartment.getDepartment(), bDepartment.getNo());
//			if (judge != "1") {
//				basicDataService.insertBaseDepartment(bDepartment);
//				map.put("judge", judge);
//			}
//			map.put("judge", judge);
//		}
//		return map;
//		// return "redirect:/html/basicDataList.html";
//	}

	/**
	 * 删除部门
	 * 
	 * @param bDepartment
	 * @return
	 */
//	@RequestMapping(value = "/deleteDepartment")
//	@ResponseBody
//	public int deleteDepartment(@RequestBody BaseDepartment bDepartment) {
//		int judge = basicDataService.deleteDepartment(bDepartment.getNo());
//		return judge;
//	}

	/**
	 * 基础信息 资产查询
	 * 
	 * @param maps
	 *            分页
	 * @return
	 */
	@RequestMapping(value = "/basicDataListAssets")
	@ResponseBody
	public Map<String, Object> basicDataListAssets(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<Assets> assets = basicDataService.assetsSelect(page);
		Map<String, Object> map = new HashMap<>();
		map.put("list", assets);
		map.put("page", page);
		return map;
	}

	/**
	 * 删除资产
	 * 
	 * @param assets
	 * @return
	 */
	@RequestMapping(value = "/deleteAssetsByNo")
	@ResponseBody
	public String deleteAssetsByNo(@RequestBody Assets assets) {
		System.out.println(assets.getNo());
		basicDataService.deleteAssetsByNo(assets.getNo());
		return "redirect:/html/basicDataList.html";
	}

	/**
	 * 删除员工
	 * 
	 * @param bDepartment
	 * @return
	 */
//	@RequestMapping(value = "/deleteWorkerByNo")
//	@ResponseBody
//	public String deleteWorkerByNo(@RequestBody Worker worker) {
//		basicDataService.deleteWorkerByNo(worker.getNo());
//		return "redirect:/html/basicDataList.html";
//	}

	/**
	 * 位置删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deletePosition")
	@ResponseBody
	public int deletePosition(@RequestBody Position position) {
		int judge = basicDataService.deletePositionByNo(position.getNo());
		return judge;
	}

	/**
	 * 基础数据 资产类别信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/basicDataListAssetClass")
	@ResponseBody
	public Map<String, Object> basicDataListAssetClass(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<BaseAssetClass> baseAssetClasse = basicDataService.assetClasseSelect(page);
		Map<String, Object> map = new HashMap<>();
		map.put("list", baseAssetClasse);
		map.put("page", page);
		return map;
	}

	/**
	 * 添加 资产类别
	 * 
	 * @param bDepartment
	 * @return
	 */
	@RequestMapping(value = "/saveAssetClasses")
	@ResponseBody
	public Map<String, Object> saveAssetClasses(@RequestBody BaseAssetClass baseAssetClass) {
		Map<String, Object> map = new HashMap<>();
		int judge = basicDataService.judgeBaseAssetClass(baseAssetClass);
		if (judge == 2) { // 2 数据库 没有 可以添加
			basicDataService.saveAssetClasses(baseAssetClass);
		}
		map.put("judge", judge);
		return map;
	}

	/**
	 * 删除 资产类别
	 * 
	 * @param baseAssetClass
	 * @return
	 */
	@RequestMapping(value = "/deleteAssetClasses")
	@ResponseBody
	public int deleteAssetClasses(@RequestBody BaseAssetClass baseAssetClass) {
		int judge = basicDataService.deleteAssetClasses(baseAssetClass.getAssetCategory());
		return judge;
	}

	/**
	 * 供应商 查询
	 * 
	 * @param maps
	 * @return
	 */
	@RequestMapping(value = "/basicDataListSupplier")
	@ResponseBody
	public Map<String, Object> basicDataListSupplier(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<Supplier> suppliers = basicDataService.supplierSelect(page);
		Map<String, Object> map = new HashMap<>();
		map.put("list", suppliers);
		map.put("page", page);
		return map;
	}

	/**
	 * 供应商 查看
	 * 
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/supplierSelectByOn")
	@ResponseBody
	public Map<String, Object> supplierSelectByOn(@RequestBody Supplier supplier) {
		Supplier supp = basicDataService.supplierSelectByNo(supplier.getNo());
		Map<String, Object> map = new HashMap<>();
		map.put("supplier", supp);
		return map;
	}

	/**
	 * 供应商 删除 (update)
	 * 
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/supplierDelectByNo")
	@ResponseBody
	public int supplierDelectByNo(@RequestBody Supplier supplier,HttpSession session) {
		User u=(User) session.getAttribute("user");
		int judge = basicDataService.supplierDeleteByNo(supplier.getNo(),u.getName());
		return judge;
	}

	/**
	 * 基础数据 供应商 拼接 编号 先查询 数据库是否存在 并查询出其max
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addSupplier")
	@ResponseBody
	public Map<String, Object> addSupplier() {
		Supplier stitchingNumber = basicDataService.stitchingNumber();
		Map<String, Object> map = new HashMap<>();
		map.put("stitchingNumber", stitchingNumber);
		return map;
	}

	/**
	 * 基础数据 供应商 保存
	 * 
	 * @param supplier
	 */
	@RequestMapping(value = "/supplierInsert")
	public String supplierInsert(Supplier supplier) {
		basicDataService.supplierInsert(supplier);
		return "redirect:/html/basicDataList.html";
	}

	/**
	 * 基础数据 供应商 修改
	 * 
	 * @param supplier
	 */
	@RequestMapping(value = "/supplierUpdate")
	public String supplierUpdate(Supplier supplier) {
		if (PositionJudge.updateSupplierJudge(supplier) == 2) {
			basicDataService.updateSupplierByNo(supplier);
		}
		return "redirect:/html/basicDataList.html";
	}

	/**
	 * 承包商查询
	 * 
	 * @param maps
	 * @return
	 */
	@RequestMapping(value = "/basicDataListBaseContractor")
	@ResponseBody
	public Map<String, Object> basicDataListBaseContractor(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<BaseContractor> baseContractors = basicDataService.baseContractorSelect(page);
		Map<String, Object> map = new HashMap<>();
		map.put("list", baseContractors);
		map.put("page", page);
		return map;
	}

	/**
	 * 基础数据 承包商 拼接 编号 先查询 数据库是否存在 并查询出其max
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addbaseContractor")
	@ResponseBody
	public Map<String, Object> addbaseContractor() {
		BaseContractor baseContractor = basicDataService.contractorNumber();
		Map<String, Object> map = new HashMap<>();
		map.put("baseContractor", baseContractor);
		return map;
	}

	/**
	 * 基础数据 供应商 保存
	 * 
	 * @param supplier
	 */
	@RequestMapping(value = "/baseContractorInsert")
	public String baseContractorInsert(BaseContractor baseContractor) {
		basicDataService.baseContractorInsert(baseContractor);
		return "redirect:/html/basicDataList.html";
	}

	/**
	 * 承包商 查看
	 * 
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/selectBaseContractorByNo")
	@ResponseBody
	public Map<String, Object> selectBaseContractorByNo(@RequestBody BaseContractor baseContractor) {
		BaseContractor supp = basicDataService.baseContractorSelectByNo(baseContractor);
		Map<String, Object> map = new HashMap<>();
		map.put("list", supp);
		return map;
	}

	/**
	 * 承包商 删除 (update)
	 * 
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/updateBaseContractorByNo")
	@ResponseBody
	public int updateBaseContractorByNo(@RequestBody BaseContractor baseContractor,HttpSession session) {
		// System.out.println("baseContractor:" + baseContractor.getNo());
		User u=(User) session.getAttribute("user");
		int judge = basicDataService.deleteBaseContractorByNo(baseContractor.getNo(),u.getName());
		return judge;
	}

	/**
	 * 基础数据 承包商 修改
	 * 
	 * @param supplier
	 */
	@RequestMapping(value = "/baseContractorUpdate")
	public String baseContractorUpdate(BaseContractor baseContractor) {
		basicDataService.updateBaseContractorByNo(baseContractor);

		return "redirect:/html/basicDataList.html";
	}

	/**
	 * 工单状态列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerorderStatesSelect")
	@ResponseBody
	public Map<String, Object> sundryWokerorderStatesSelect() {
		List<SundryWokerorderState> list = basicDataService.sundryWokerorderStatesSelect();
		List<SundryWokerorderClass> lists = basicDataService.selectSundryWokerorderClass();
		List<BaseAssetClass> troc = basicDataService.selectBaseAssetClass();
		List<SundryAssetsState> sat = basicDataService.selectSundryAssetsState();
		List<SundryAssetsWay> saw = basicDataService.selectSundryAssetsWay();
		List<SundryWorkerClass> sundryWokerClass = basicDataService.selectSundryWokerClass();
		List<SundryJobClass> sundryJobClass = basicDataService.selectSundryJobClass();
		List<SundryJobPriority> selectSundryJobPriority = basicDataService.selectSundryJobPriority();
		List<BaseAssetClass> baseAssetClasses = basicDataService.selectBaseAssetClass();
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("swc", lists);
		map.put("troc", troc);
		map.put("sat", sat);
		map.put("saw", saw);
		map.put("baseAssetClasses", baseAssetClasses);
		map.put("sundryWokerClass", sundryWokerClass);
		map.put("sundryUrgencyLevel", sundryJobClass);
		map.put("selectSundryJobPriority", selectSundryJobPriority);
		return map;
	}

	/**
	 * 工单状态 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerorderStatesInsert")
	@ResponseBody
	public int sundryWokerorderStatesInsert(@RequestBody SundryWokerorderState state) {
		int judge = basicDataService.judgeSundryWokerorderState(state); // 判断数据库是否已存在
		if (judge == 2) {
			basicDataService.sundryWokerorderStatesInsert(state);
		}
		return judge;
	}

	/**
	 * 工单状态列表delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerorderStatesDelete")
	@ResponseBody
	public String sundryWokerorderStatesDelete(@RequestBody SundryWokerorderState state) {
		String jundge = basicDataService.sundryWokerorderStatesDelete(state.getInformation());
		return jundge;
	}

	/**
	 * 工单类型 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerorderClassInsert")
	@ResponseBody
	public int sundryWokerorderClassInsert(@RequestBody SundryWokerorderClass state) {
		int judge = basicDataService.judgeSundryWokerorderClass(state);
		if (judge == 2) {
			basicDataService.sundryWokerorderClassInsert(state);
		}
		return judge;
	}

	/**
	 * 工单类型 列表delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerorderClassDelete")
	@ResponseBody
	public String sundryWokerorderClassDelete(@RequestBody SundryWokerorderState state) {
		String judge = basicDataService.sundryWokerorderClassDelete(state.getInformation());
		return judge;
	}

	/**
	 * 基础数据 综合 员工类型 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerClassInsert")
	@ResponseBody
	public int sundryWokerClassInsert(@RequestBody SundryWorkerClass sundryWokerClass) {
		int judge = basicDataService.judgeSundryWorkerClass(sundryWokerClass);
		if (judge == 2) {
			basicDataService.sundryWokerClassInsert(sundryWokerClass);
		}
		return judge;
	}

	/**
	 * 基础数据 综合 员工类型 delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryWokerClassDelete")
	@ResponseBody
	public String sundryWokerClassDelete(@RequestBody SundryWorkerClass sundryWokerClass) {
		String judge = basicDataService.sundryWokerClassDelete(sundryWokerClass.getInformation());
		return judge;
	}

	/**
	 * 基础数据 综合 资产状态列表 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryAssetsStateInsert")
	@ResponseBody
	public int sundryAssetsStateInsert(@RequestBody SundryAssetsState state) {
		int judge = basicDataService.judgeSundryAssetsState(state);
		if (judge == 2) {
			basicDataService.sundryAssetsStateInsert(state);
		}
		return judge;
	}

	/**
	 * 基础数据 综合 资产状态列表delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryAssetsStateDelete")
	@ResponseBody
	public String sundryAssetsStateDelete(@RequestBody SundryAssetsState state) {
		String judge = basicDataService.sundryAssetsStateDelete(state.getInformation());
		return judge;
	}

	/**
	 * 基础数据 综合 保修/外包 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryAssetsWayInsert")
	@ResponseBody
	public int sundryAssetsWayInsert(@RequestBody SundryAssetsWay state) {
		int judge = basicDataService.judgeSundryAssetsWay(state);
		if (judge == 2) {
			basicDataService.sundryAssetsWayInsert(state);
		}
		return judge;
	}

	/**
	 * 基础数据 综合 保修/外包delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryAssetsWayDelete")
	@ResponseBody
	public String sundryAssetsWayDelete(@RequestBody SundryAssetsWay state) {
		String judge = basicDataService.sundryAssetsWayDelete(state.getInformation());
		return judge;
	}

	/**
	 * 基础数据 综合 综合 工作类别 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryUrgencyLevelInsert")
	@ResponseBody
	public int sundryUrgencyLevelInsert(@RequestBody SundryJobClass state) {
		int judge = basicDataService.judgeSundryUrgencyLevel(state);
		if (judge == 2) {
			basicDataService.sundryUrgencyLevelInsert(state);
		}
		return judge;
	}

	/**
	 * 基础数据 综合 工作类别 Delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryUrgencyLevelDelete")
	@ResponseBody
	public int sundryUrgencyLevelDelete(@RequestBody SundryJobClass state) {
		int judge = basicDataService.sundryUrgencyLevelDelete(state.getInformation());
		return judge;
	}

	/**
	 * 基础数据 综合 工作优先级 add
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryJobPriorityInsert")
	@ResponseBody
	public ModelAndView sundryJobPriorityInsert(@RequestBody SundryJobPriority state) {
		int judge = basicDataService.judgeSundryJobPriority(state);
		if (judge == 2) {
			basicDataService.sundryJobPriorityInsert(state);
		}
		return new ModelAndView(new RedirectView("sundryWokerorderStatesSelect"));
	}

	/**
	 * 基础数据 综合 工作优先级 delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sundryJobPriorityDelete")
	@ResponseBody
	public ModelAndView sundryJobPriorityDelete(@RequestBody SundryJobPriority state) {
		basicDataService.sundryJobPriorityDelete(state.getInformation());
		return new ModelAndView(new RedirectView("sundryWokerorderStatesSelect"));
	}

	/**
	 * 上传
	 * @param multipartFile
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public int uploadFile(@ModelAttribute MultipartFile multipartFile, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(multipartFile.getOriginalFilename());
		File file = new File(
				request.getServletContext().getRealPath("/file/" + multipartFile.getOriginalFilename() + ""));
		System.out.println(file.getAbsolutePath());
		// System.out.println(file.getAbsolutePath()); 获取相对路径
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int judge = basicDataService.SecurityGuidance(multipartFile.getOriginalFilename(), file.getAbsolutePath());
		return judge;
	}

	/**
	 * 安全操作指导
	 * 
	 * @param maps
	 *            分页
	 * @return
	 */
	@RequestMapping(value = "/listUploadFile")
	@ResponseBody
	public Map<String, Object> listUploadFile(@RequestBody Map<String, String> maps) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<UploadFile> uploadFile = basicDataService.listUploadFile(page);
		Map<String, Object> map = new HashMap<>();
		map.put("uploadFile", uploadFile);
		map.put("page", page);
		return map;
	}

	/**
	 * delete
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping(value = "deleteSecurityGuidance")
	@ResponseBody
	public int deleteSecurityGuidance(@RequestBody UploadFile uploadFile) {
		basicDataService.deleteSecurityGuidance(uploadFile.getNo());
		return 1;
	}


	/**
	 *  download
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("no") != null &&! request.getParameter("no").equals("")){
		UploadFile file = basicDataService.downloadUploadFile(request.getParameter("no"));
		// 获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
		String path = file.getUrl();
		File file2 = new File(path);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
		response.setHeader("Content-Disposition", "attachment;filename="+parseGBK(file2.getName()));
		ServletOutputStream out;
		// 通过文件路径获得File对象(假如此路径中有一个download.pdf文件)

		try {
			FileInputStream inputStream = new FileInputStream(file2);
			// 3.通过response获取ServletOutputStream对象(out)
			out = response.getOutputStream();

			int b = 0;
			byte[] buffer = new byte[1024];
			while ((b = inputStream.read(buffer))>0) {
				// 4.写到输出流(out)中
				out.write(buffer, 0, b);
			}
			inputStream.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

	//中文
	public String parseGBK(String sIn) {
		if (sIn == null || sIn.equals(""))
			return sIn;
		try {
			return new String(sIn.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException usex) {
			return sIn;
		}
	}
	
//	@RequestMapping(value = "/jump")
//	 public ModelAndView  jump(){
//		 return new ModelAndView(new RedirectView("listUploadFile"));
//	 }
	
	@RequestMapping(value = "/jump")
	 public String  jump(){
//		String aString  = null;
//		aString= HttpUtil.doPost(URL.toString(), map);  发送  url 
		return "redirect:/html/basicDataList.html";
	 }

	
}
