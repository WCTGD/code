package com.xyb2c.util.position;

import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.Supplier;

public class PositionJudge {
	public static int judge(LocationConditions position){
		if(position.getPosition() == null || position.getPosition().equals("") || position.getBid()== null || position.getBid().equals("") || position.getNote() == null || position.getNote().equals("")){
			return 1;
		}
		return 2;
	}
	
	public static int positionIdJudge(Object object){
		if(object == null || object.equals("")){
			System.out.println(1);
			return 1;
		}
		return 2;
	}
	
	public static int LocationConditionsJudge(LocationConditions lC){
		if(lC.getaNo() == null || lC.getJudge() == null || lC.getBid() == null || lC.getNote() == null ||lC.getaNo().equals("") || lC.getJudge().equals("") || lC.getBid().equals("") || lC.getNote().equals("")){
		return 1;
		}
		return 2;
	}
	
	public static int delectById(String id){
		if(id == null || id.equals("") || id.length() == 0){
			return 1;
		}
		return 2;
	}
	
	@SuppressWarnings("null")
	public static int insterSelectJudge(String id,String no){
		if(id == null && id.equals("") && no == null && no.equals("")){
			return 1;
		}
		return 2;
	}
	
	public static int insterDepartmentJudge(BaseDepartment aDepartment){
		if(aDepartment.getNo() == null || aDepartment.getNo().equals("") || aDepartment.getDepartment() == null || aDepartment.getDepartment().equals("") ){
			return 1;
		}
		return 2;
	}
	
	public static int updateSupplierJudge(Supplier s){
		if(s.getNo().equals("") || s.getNo() == null || s.getSupplierName().equals("") || s.getSupplierName() == null || s.getCountry().equals("") || s.getCountry() == null || s.getProvince().equals("") || s.getProvince() == null ||
				 s.getCity().equals("") || s.getCity() == null || s.getZipCode().equals("") || s.getZipCode() == null || s.getTelphone().equals("") || s.getTelphone() == null ||
				 s.getFax().equals("") || s.getFax() == null || s.getEmail().equals("") || s.getEmail() == null || s.getContactName().equals("") || s.getContactName() == null || s.getContactJob().equals("") || s.getContactJob() == null ||
				 s.getContactAddress().equals("") || s.getContactAddress() == null){
			return 1;
		}
		return 2;
	}
	
	public static int updateBaserContractorJudge(BaseContractor obj){
		if (obj.getNo().equals("") || obj.getNo() == null || obj.getName().equals("") || obj.getName() == null || obj.getContactName().equals("") || obj.getContactName() == null || obj.getEmail().equals("") || obj.getEmail() == null || obj.getAddress().equals("") || obj.getAddress() == null ||
			obj.getProvince().equals("") || obj.getProvince() == null || obj.getCity().equals("") || obj.getCity() == null || obj.getTelphone().equals("") || obj.getTelphone() == null || obj.getFax().equals("") || obj.getFax() == null || obj.getService().equals("") || obj.getService() == null) {
			return 1;
		}
		return 2;
	}

}
