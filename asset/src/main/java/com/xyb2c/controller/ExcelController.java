package com.xyb2c.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.Maintain;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.RepairList;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.Worker;
import com.xyb2c.service.AssetsService;
import com.xyb2c.service.BasicDataService;
import com.xyb2c.service.MaintainService;
import com.xyb2c.service.PositionService;
import com.xyb2c.service.RepairlistService;
import com.xyb2c.service.WorkerService;
import com.xyb2c.util.ExcelUtil;

@Controller
@RequestMapping(value = "excel")
public class ExcelController {
	@Autowired
	RepairlistService repairlistService;
	@Autowired
	AssetsService assetsService;
	@Autowired
	BasicDataService basicDataService;
	@Autowired
	PositionService positionService;
	@Autowired
	MaintainService maintainService;
	@Autowired
	WorkerService workerService;

	/**
	 * 维修下载
	 * @param response
	 * @param d1
	 * 发起时间1
	 * @param d2
	 * 发起时间2
	 * @param assetsClassId
	 * 资产类型id
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "repairlistdown")
	public @ResponseBody void reparlistDown(HttpServletResponse response,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer assetsClassId) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("工单编号");
		rowname.add("问题描述");
		rowname.add("工单类型");
		rowname.add("资产编号");
		rowname.add("资产描述");
		rowname.add("位置编号");
		rowname.add("接受日期");
		rowname.add("开始日期");// 有问题
		rowname.add("完成日期");
		rowname.add("工单状态");
		List<RepairList> list = repairlistService.select(null, assetsClassId, d1, d2, 0, 2147483647, null, 1);
		for (RepairList repairList : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(repairList.getNo());
			datarow.add(repairList.getNote() != null ? repairList.getNote() : "");
			datarow.add(repairList.getWokerorderClass().getInformation());
			datarow.add(repairList.getAssets().getNo());
			datarow.add(repairList.getAssets().getAssetDesc());
			datarow.add(repairList.getLaunchTime() != null ? repairList.getLaunchTime().toLocaleString() : "");
			datarow.add(repairList.getStartTime() != null ? repairList.getStartTime().toLocaleString() : "");
			datarow.add(repairList.getRealFinishTime() != null ? repairList.getRealFinishTime().toLocaleString() : "");
			datarow.add(repairList.getWokerorderState().getInformation());
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("工单列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 维修详情下载
	 * @param response
	 * @param d1
	 * 发起时间1
	 * @param d2
	 * 发起时间2
	 * @param assetsClassId
	 * 资产类型ID
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "reparlistdetaildown")
	public @ResponseBody void reparlistDetailDown(HttpServletResponse response,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer assetsClassId) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("工单编号");
		rowname.add("工单类型");
		rowname.add("问题描述");
		rowname.add("请求者");
		rowname.add("资产编号");
		rowname.add("资产描述");
		rowname.add("位置编号");
		rowname.add("位置描述");
		rowname.add("接受日期");
		rowname.add("预计完成日期");
		rowname.add("工单状态");
		rowname.add("工作优先级");
		List<RepairList> list = repairlistService.select(null, assetsClassId, d1, d2, 0, 2147483647, null, 1);
		for (RepairList repairList : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(repairList.getNo());
			datarow.add(repairList.getWokerorderClass().getInformation());
			datarow.add(repairList.getNote() != null ? repairList.getNote() : "");
			datarow.add(repairList.getWorker().getName());
			datarow.add(repairList.getAssets().getNo());
			datarow.add(repairList.getAssets().getAssetDesc());
			datarow.add(repairList.getAssets().getPosition().getNo());
			datarow.add(repairList.getAssets().getPosition().getPosition());
			datarow.add(repairList.getLaunchTime().toLocaleString());
			datarow.add(repairList.getFinishTime().toLocaleString());
			datarow.add(repairList.getWokerorderState().getInformation());
			datarow.add(repairList.getLevel().getInformation());
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("工单详情列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 假删维修查询
	 * @param response
	 * @param d1
	 * 发起时间1
	 * @param d2
	 * 发起时间2
	 * @param assetsClassId
	 * 资产类型ID
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "deletereparlistdown")
	public @ResponseBody void deleteReparlistDown(HttpServletResponse response,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer assetsClassId) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("工单编号");
		rowname.add("问题描述");
		rowname.add("工单类型");
		rowname.add("资产编号");
		rowname.add("资产描述");
		rowname.add("位置编号");
		rowname.add("接受日期");
		rowname.add("开始日期");
		rowname.add("完成日期");
		rowname.add("工单状态");
		List<RepairList> list = repairlistService.select(null, assetsClassId, d1, d2, 0, 2147483647, null, 0);
		for (RepairList repairList : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(repairList.getNo());
			datarow.add(repairList.getNote() != null ? repairList.getNote() : "");
			datarow.add(repairList.getWokerorderClass().getInformation());
			datarow.add(repairList.getAssets().getNo());
			datarow.add(repairList.getAssets().getAssetDesc());
			datarow.add(repairList.getAssets().getPosition().getNo());
			datarow.add(repairList.getCreateTime().toLocaleString());
			datarow.add(repairList.getStartTime() != null ? repairList.getStartTime().toLocaleString() : "");
			datarow.add(repairList.getFinishTime() != null ? repairList.getFinishTime().toLocaleString() : "");
			datarow.add(repairList.getWokerorderState().getInformation());
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("关闭工单列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 供应商下载
	 * @param response
	 */
	@RequestMapping(value = "supplierDown")
	public @ResponseBody void supplierDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("供应商编号");
		rowname.add("供应商名称");
		rowname.add("联系人姓名");
		rowname.add("职位");
		rowname.add("电话号码");
		rowname.add("服务");
		PageBean page = new PageBean();
		page.setPageSize(2147483647);
		List<Supplier> sup = basicDataService.supplierSelect(page);
		for (Supplier supplier : sup) {
			List<String> rowdata = new ArrayList<>();
			rowdata.add(supplier.getNo());
			rowdata.add(supplier.getSupplierName());
			rowdata.add(supplier.getContactName());
			rowdata.add(supplier.getContactJob());
			rowdata.add(supplier.getTelphone());
			rowdata.add(supplier.getService());
			data.add(rowdata);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("供应商列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 供应商详情下载
	 * @param response
	 */
	@RequestMapping(value = "supplierdetaildown")
	public @ResponseBody void supplierDetailDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("供应商编号");
		rowname.add("供应商名称");
		rowname.add("联系人");
		rowname.add("职位");
		rowname.add("地址");
		rowname.add("城市");
		rowname.add("省");
		rowname.add("邮箱");
		rowname.add("电话");
		rowname.add("传真");
		rowname.add("服务");
		PageBean page = new PageBean();
		page.setPageSize(2147483647);
		List<Supplier> sup = basicDataService.supplierSelect(page);
		for (Supplier supplier : sup) {
			List<String> rowdata = new ArrayList<>();
			rowdata.add(supplier.getNo());
			rowdata.add(supplier.getSupplierName());
			rowdata.add(supplier.getContactName());
			rowdata.add(supplier.getContactJob());
			rowdata.add(supplier.getContactAddress());
			rowdata.add(supplier.getCity());
			rowdata.add(supplier.getProvince());
			rowdata.add(supplier.getEmail());
			rowdata.add(supplier.getTelphone());
			rowdata.add(supplier.getFax());
			rowdata.add(supplier.getService());
			data.add(rowdata);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("供应商详情列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 部门下载
	 * @param response
	 */
	@RequestMapping(value = "departmentdown")
	public @ResponseBody void departmentDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("部门编号");
		rowname.add("部门描述");
		List<BaseDepartment> list = assetsService.selectAllBaseDepartment().get("small");
		for (BaseDepartment baseDepartment : list) {
			List<String> datason = new ArrayList<>();
			datason.add(baseDepartment.getNo());
			datason.add(baseDepartment.getDepartment());
			data.add(datason);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("部门列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 位置下载
	 * @param response
	 */
	@RequestMapping(value = "positiondown")
	public @ResponseBody void positionDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("位置编号");
		rowname.add("位置描述");
		rowname.add("部门编号");
		rowname.add("部门描述");
		LocationConditions lc = new LocationConditions();
		PageBean page = new PageBean();
		page.setPageSize(2147483647);
		List<LocationConditions> list = positionService.positionList(lc, page);
		for (LocationConditions l : list) {
			List<String> rowdata = new ArrayList<>();
			rowdata.add(l.getaNo());
			rowdata.add(l.getPosition());
			rowdata.add(l.getbNo());
			rowdata.add(l.getDepartment());
			data.add(rowdata);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("位置列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 资产详情下载
	 * @param response
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param did
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "assetsdetaildown")
	public @ResponseBody void assetsDetailDown(HttpServletResponse response,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer did) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("资产编号");
		rowname.add("资产描述");
		rowname.add("资产状态");
		rowname.add("位置编号");
		rowname.add("部门编号");
		rowname.add("部门描述");
		rowname.add("资产类别");
		rowname.add("序列号");
		rowname.add("型号");
		rowname.add("生产商");
		rowname.add("资产注释");
		rowname.add("保修截止日期");
		rowname.add("供应商姓名");
		rowname.add("采购价格");
		rowname.add("启用日期");
		rowname.add("授权员工");
		List<Assets> list = assetsService.formSelect(0, 2147483647, d1, d2, did);
		for (Assets assets : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(assets.getNo());
			datarow.add(assets.getAssetDesc());
			datarow.add(assets.getSundryAssetsState().getInformation());
			if (assets.getPosition() != null) {
				datarow.add(assets.getPosition().getNo());
			} else {
				datarow.add("");
			}
			if (assets.getBaseDepartment() != null) {
				datarow.add(assets.getBaseDepartment().getNo());
				datarow.add(assets.getBaseDepartment().getDepartment());
			} else {
				datarow.add("");
				datarow.add("");
			}
			datarow.add(assets.getBaseAssetClass().getAssetCategory());
			if (assets.getSerialNo() != null) {
				datarow.add(assets.getSerialNo());
			} else {
				datarow.add("");
			}
			if (assets.getType() != null) {
				datarow.add(assets.getType());
			} else {
				datarow.add("");
			}
			if (assets.getManufacturer() != null) {
				datarow.add(assets.getManufacturer());
			} else {
				datarow.add("");
			}
			datarow.add(assets.getNote());
			if (assets.getWarrantyDeadline() != null) {
				datarow.add(assets.getWarrantyDeadline().toLocaleString());
			} else {
				datarow.add("");
			}
			datarow.add(assets.getSupplier().getContactName());
			if (assets.getPurchaserPrice() != null) {
				datarow.add(assets.getPurchaserPrice() + "");
			} else {
				datarow.add("");
			}
			datarow.add(assets.getStartDate().toLocaleString());
			if (assets.getWorker() != null) {
				datarow.add(assets.getWorker().getName());
			} else {
				datarow.add("");
			}
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("资产列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 资产下载
	 * @param response
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param did
	 * 部门id
	 */
	@RequestMapping(value = "assetsdown")
	public @ResponseBody void assetsDown(HttpServletResponse response, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d2, Integer did) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("资产编号");
		rowname.add("资产描述");
		rowname.add("位置编号");
		rowname.add("资产类别");
		rowname.add("型号");
		rowname.add("序列号");
		rowname.add("状态");
		rowname.add("部门");
		rowname.add("采购价格");
		List<Assets> list = assetsService.formSelect(0, 2147483647, d1, d2, did);
		for (Assets assets : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(assets.getNo());
			datarow.add(assets.getAssetDesc());
			if (assets.getPosition() != null) {
				datarow.add(assets.getPosition().getNo());
			} else {
				datarow.add("");
			}
			datarow.add(assets.getBaseAssetClass().getAssetCategory());
			if (assets.getType() != null) {
				datarow.add(assets.getType());
			} else {
				datarow.add("");
			}
			if (assets.getSerialNo() != null) {
				datarow.add(assets.getSerialNo());
			} else {
				datarow.add("");
			}
			datarow.add(assets.getSundryAssetsState().getInformation());
			if (assets.getBaseDepartment() != null) {
				datarow.add(assets.getBaseDepartment().getDepartment());
			} else {
				datarow.add("");
			}
			if (assets.getPurchaserPrice() != null) {
				datarow.add(assets.getPurchaserPrice() + "");
			} else {
				datarow.add("");
			}
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("资产列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 报表资产查询
	 * @param page
	 * 页码
	 * @param size
	 * 每页长度
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param did
	 * 部门ID
	 * @return
	 */
	@RequestMapping(value = "formselect")
	public @ResponseBody Map<String, Object> formSelect(Integer page, Integer size,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer did) {
		Map<String, Object> map = new HashMap<>();
		if (page == null) {
			page = 1;
		}
		int start = (page - 1) * size;
		List<Assets> assets = assetsService.formSelect(start, size, d1, d2, did);
		int count = assetsService.formCount(d1, d2, did);
		int pagesize = count / size;
		if (count % size != 0) {
			pagesize += 1;
		}
		map.put("start", start + 1);
		map.put("end", start + size);
		map.put("assets", assets);
		map.put("page", page);
		map.put("count", count);
		map.put("pagesize", pagesize);
		return map;
	}
	/**
	 * 
	 * @param page
	 * 页码
	 * @param size
	 * 每页长度
	 * @return
	 */
	@RequestMapping(value = "departmentselect")
	public @ResponseBody Map<String, Object> departmentSelect(Integer page, Integer size) {
		Map<String, Object> map = new HashMap<>();
		if (page == null) {
			page = 1;
		}
		int start = (page - 1) * size;
		List<BaseDepartment> list = assetsService.selectAllBaseDepartment().get("small");
		int count = list.size();
		int pagesize = count / size;
		if (count % size != 0) {
			pagesize += 1;
		}
		int sub = start + size;
		if (sub > (count - 1)) {
			sub = count;
		}
		try {
			map.put("data", list.subList(start, sub));
		} catch (Exception e) {
			map.put("data", new ArrayList<>());
		}
		map.put("start", start + 1);
		map.put("end", start + size);
		map.put("page", page);
		map.put("count", count);
		map.put("pagesize", pagesize);
		return map;
	}
	/**
	 * 维护下载
	 * @param response
	 * @param plan
	 * 计划工单标识
	 */
	@RequestMapping(value = "maintaindown")
	public @ResponseBody void maintainDown(HttpServletResponse response, Integer plan) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("任务编号");
		rowname.add("任务名称");
		rowname.add("预计工时");
		List<Maintain> list = maintainService.select(0, 2147483647, null, null, null, null, null, plan);
		for (Maintain maintain : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(maintain.getNo());
			datarow.add(maintain.getName());
			datarow.add(maintain.getWorkday() != null ? maintain.getWorkday() + "天" : "");
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("维护列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 维护详情下载
	 * @param response
	 * @param plan
	 * 计划工单标识
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "maintaindetaildown")
	public @ResponseBody void maintainDetailDown(HttpServletResponse response, Integer plan) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("预防性维护编号");
		rowname.add("预防性维护名称");
		rowname.add("资产属性");
		rowname.add("工作类型");
		rowname.add("工单类型");
		rowname.add("预计开始日期");
		rowname.add("预计完成日期");
		rowname.add("基准维护信息");
		List<Maintain> list = maintainService.select(0, 2147483647, null, null, null, null, null, plan);
		for (Maintain maintain : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(maintain.getNo());
			datarow.add(maintain.getName());
			if (maintain.getAssets() != null) {
				datarow.add(maintain.getAssets().getPositionId() != null ? "私有资产" : "公共资产");
			} else {
				datarow.add("");
			}
			datarow.add(maintain.getSundryJobClass().getInformation());
			datarow.add("预防性维护");
			datarow.add(maintain.getStartdate().toLocaleString());
			datarow.add(maintain.getStartdate().toLocaleString());
			datarow.add(maintain.getaId()==null?"位置":"资产");
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("维护详情列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param assetsClassId
	 * 资产类型id
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param pid
	 * 位置id
	 * @param page
	 * 页码
	 * @param size
	 * 每页长度
	 * @param flag
	 * 删除标记
	 * @return
	 */
	@RequestMapping(value = "positionrepairselect")
	public @ResponseBody Map<String, Object> positionRepairSelect(Integer assetsClassId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2,
			Integer pid, Integer page, Integer size, Integer flag) {
		Map<String, Object> map = new TreeMap<>();
		int start = (page - 1) * size;
		int count = repairlistService.count(null, assetsClassId, d1, d2, pid, flag);
		int pagesize = count / size;
		if (count % size > 0) {
			pagesize++;
		}
		map.put("repairList", repairlistService.select(null, assetsClassId, d1, d2, start, size, pid, flag));
		map.put("count", count);
		map.put("pagesize", pagesize);
		map.put("start", start + 1);
		map.put("end", start + size);
		return map;
	}
	/**
	 * 位置历史工单下载
	 * @param response
	 * @param pid
	 * 位置id
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "positionhistorydown")
	public @ResponseBody void positionHistoryDown(HttpServletResponse response, Integer pid) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("位置编号");
		rowname.add("位置描述");
		rowname.add("部门");
		rowname.add("工单编号");
		rowname.add("问题描述");
		rowname.add("工单类型");
		rowname.add("资产编号");
		rowname.add("资产类型");
		rowname.add("接受日期");
		rowname.add("开始日期");
		rowname.add("完成日期");
		rowname.add("工单状态");
		List<RepairList> list = repairlistService.select(null, null, null, null, 0, 2147483647, pid, 1);
		for (RepairList repairList : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(repairList.getAssets().getPosition().getNo());
			datarow.add(repairList.getAssets().getPosition().getPosition());
			datarow.add(repairList.getAssets().getBaseDepartment().getDepartment());
			datarow.add(repairList.getNo());
			datarow.add(repairList.getNote() != null ? repairList.getNote() : "");
			datarow.add(repairList.getAssets().getNo());
			datarow.add(repairList.getWokerorderClass().getInformation());
			datarow.add(repairList.getCreateTime().toLocaleString());
			datarow.add(repairList.getStartTime().toLocaleString());
			if (repairList.getRealFinishTime() == null) {
				datarow.add("");
			} else {
				datarow.add(repairList.getRealFinishTime().toLocaleString());
			}
			datarow.add(repairList.getWokerorderState().getInformation());
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("工单列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 员工查询
	 * @param page
	 * 页码
	 * @param size
	 * 每页长度
	 * @return
	 */
	@RequestMapping(value = "workerselect")
	public @ResponseBody Map<String, Object> worker(Integer page, Integer size) {
		Map<String, Object> map = new TreeMap<>();
		int start = (page - 1) * size;
		int count = workerService.count();
		int pagesize = count / size;
		if (count % size > 0) {
			pagesize++;
		}
		map.put("data", workerService.selectPage(start, size));
		map.put("count", count);
		map.put("pagesize", pagesize);
		map.put("start", start + 1);
		map.put("end", start + size);
		return map;
	}
	/**
	 * 员工下载
	 * @param response
	 */
	@RequestMapping(value = "workerdown")
	public @ResponseBody void workerDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("员工编号");
		rowname.add("姓名");
		rowname.add("职位");
		rowname.add("部门");
		rowname.add("联系方式");
		rowname.add("类别");
		List<Worker> list = workerService.selectPage(0, 2147483647);
		for (Worker worker : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(worker.getId()+"");
			datarow.add(worker.getName());
			datarow.add(worker.getJob()!=null?worker.getJob():"");
			datarow.add(worker.getDepartment()!=null?worker.getDepartment():"");
			datarow.add(worker.getMobilePhone()!=null?worker.getMobilePhone():"");
			datarow.add(worker.getInformation()!=null?worker.getInformation():"");
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("员工列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 员工详情下载
	 * @param response
	 */
	@RequestMapping(value = "workerdetaildown")
	public @ResponseBody void workerDetailDown(HttpServletResponse response) {
		List<String> rowname = new ArrayList<>();
		List<List<String>> data = new ArrayList<>();
		rowname.add("员工编号");
		rowname.add("姓名");
		rowname.add("职位");
		rowname.add("地址");
		rowname.add("部门编号");
		rowname.add("部门描述");
		rowname.add("E-mail");
		rowname.add("联系电话");
		rowname.add("位置");
		List<Worker> list = workerService.selectPage(0, 2147483647);
		for (Worker worker : list) {
			List<String> datarow = new ArrayList<>();
			datarow.add(worker.getId()+"");
			datarow.add(worker.getName());
			datarow.add(worker.getJob()!=null?worker.getJob():"");
			datarow.add(worker.getAddress()!=null?worker.getAddress():"");
			datarow.add(worker.getDepartmentNo()!=null?worker.getDepartmentNo():"");
			datarow.add(worker.getDepartment()!=null?worker.getDepartment():"");
			datarow.add(worker.getEmail()!=null?worker.getEmail():"");
			datarow.add(worker.getMobilePhone()!=null?worker.getMobilePhone():"");
			datarow.add(worker.getPosition()!=null?worker.getPosition():"");
			data.add(datarow);
		}
		byte[] bytes = ExcelUtil.getExcleBytes(rowname, data);
		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(("员工详情列表.xlsx").getBytes("gbk"), "iso-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentLength(bytes.length);
		try {
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
