package com.xyb2c.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;

public class RecursionUtil {

	static final BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	static BaseDepartmentMapper departmentMapper = factory.getBean(BaseDepartmentMapper.class);

	public static class DeptNote {
		public Integer value;// 对应base_department表中的p_id
		public List<DeptNote> children = new ArrayList<>();

		public DeptNote(Integer value) {
			super();
			this.value = value;
		}

		public DeptNote(Integer value, List<DeptNote> children) {
			super();
			this.value = value;
			this.children = children;
		}

		@Override
		public String toString() {
			return "DeptNote [value=" + value + ", children=" + children + "]";
		}

	}

	public static DeptNote getDeptNote(DeptNote note, Integer value) {
		if (note != null && value != null) {
			if (note.value == value) {
				return note;
			} else {
				if (note.children != null) {
					for (DeptNote n : note.children) {
						return getDeptNote(n, value);
					}
				}
			}
		}
		return null;
	}

	public static void addChildrenTreeNote(DeptNote root, Integer value, DeptNote childrenNode) {
		if (root.value == value) {
			root.children.add(childrenNode);
		} else {
			if (root.children != null) {
				for (DeptNote n : root.children) {
					addChildrenTreeNote(n, value, childrenNode);
				}
			}
		}
	}

	public static DeptNote createTree(DeptNote root, List<BaseDepartment> list) {
		List<Integer> childrens = getChildrenId(list, root.value);
		for (Integer id : childrens) {
			addChildrenTreeNote(root, 0, new DeptNote(id));
		}
		return null;
	}

	public static Integer getDeptPid(List<BaseDepartment> list, Integer id) {
		for (BaseDepartment dept : list) {
			if (dept.getId() == id) {
				return dept.getpId();
			}
		}
		return null;
	}

	public static List<Integer> getChildrenId(List<BaseDepartment> list, Integer id) {
		List<Integer> childrens = new ArrayList<>();
		for (BaseDepartment dept : list) {
			if (dept.getpId() == id) {
				childrens.add(dept.getId());
			}
		}
		return childrens;
	}

	/**
	 * 根据vale的值添加子节点
	 */
	public static void addChildren(List<BaseDepartment> depts, DeptNote root) {
		List<Integer> childrens = getChildrenId(depts, root.value);
		for (Integer i : childrens) {
			addChildrenTreeNote(root, root.value, new DeptNote(i));
		}
		for (DeptNote dept : root.children) {
			addChildren(depts, dept);
		}
	}

	public static void printTree(DeptNote root, String prefix) {
		if (!root.children.isEmpty()) {
			for (DeptNote dept : root.children) {
				printTree(dept, root.value + "---");
			}
		}
	}

	public static DeptNote digui(DeptNote root, int i) {
		if (root != null) {
			if (root.value == i) {
				return root;
			} else {
				for (DeptNote deptNoteChildren : root.children) {
					DeptNote note = digui(deptNoteChildren, i);
					if (note != null) {
						return note;
					}
				}

			}
		}
		return null;
	}

	/**
	 * 递归得到当前节点下的所有value
	 * 
	 * @param deptNote
	 *            节点
	 * @return
	 */
	public static List<Integer> getListValue(DeptNote deptNote) {
		List<Integer> list = new ArrayList<>();
		if (deptNote != null) {
			list.add(deptNote.value);
			if (!deptNote.children.isEmpty()) {
				for (DeptNote note : deptNote.children) {
					List<Integer> value = getListValue(note);
					list.addAll(value);
				}
			}
			return list;
		}

		return null;
	}

	/**
	 * 通过传入的部门的id返回该部门下的所有id，也包括自己
	 * 
	 * @param baseDepartments
	 * @param i
	 * @return
	 */
	public static List<Integer> getListPid(List<BaseDepartment> baseDepartments, int i) {
		DeptNote root = new DeptNote(0);
		addChildren(baseDepartments, root);
		DeptNote list = digui(root, i);
		List<Integer> aa = getListValue(list);
		return aa;
	}

	/**
	 * 
	 * 
	 * @param baseDepartments
	 * @param departName
	 * @param pid
	 * @return
	 */

	@SuppressWarnings("unused")
	public static BaseDepartment StringToDepartName(List<BaseDepartment> baseDepartments, BaseDepartment department) {
		if (department != null && baseDepartments.size() > 0) {
			if (department.getpId() <= 5) {
				return department;
			} else {

				String departName = department.getDepartment();
				int pid = department.getpId();
				int i = 0;
				DeptNote root = new DeptNote(0);
				addChildren(baseDepartments, root);
				DeptNote list = digui(root, pid);

				while (!getTwoDepartment(baseDepartments).contains(list.value)) {
					list = aa(root, list);
				}
				i = list.value;
				for (BaseDepartment baseDepartment : baseDepartments) {
					if (baseDepartment.getId() == i) {
						return baseDepartment;
					}
				}
			}
		}
		return null;
	}

	public static DeptNote aa(DeptNote root, DeptNote note) {
		if (root != null) {
			if (root.children.contains(note)) {
				return root;
			} else {
				for (DeptNote deptNoteChildren : root.children) {
					DeptNote no = aa(deptNoteChildren, note);
					if (no != null) {
						return no;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 拿到所有的二级部门
	 * 
	 * @param baseDepartments
	 * @return
	 */
	public static List<Integer> getTwoDepartment(List<BaseDepartment> baseDepartments) {
		List<Integer> list = new ArrayList<>();
		DeptNote root = new DeptNote(0);
		addChildren(baseDepartments, root);
		DeptNote deptNote = digui(root, 0);

		for (DeptNote de : deptNote.children) {
			list.add(de.value);
		}
		List<Integer> list2 = new ArrayList<>();
		for (Integer i : list) {
			DeptNote dept = digui(root, i);
			for (DeptNote de : dept.children) {
				list2.add(de.value);
			}
		}

		return list2;
	}

	public static void main(String[] args) {

		BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
		List<BaseDepartment> baseDepartments = departmentMapper.selectByExample(baseDepartmentExample);
		DeptNote root = new DeptNote(0);
		addChildren(baseDepartments, root);
		printTree(root, "0");
//		System.out.println(root.toString());
//		 System.out.println(root.toString());
//		 int i = 8;
//		 DeptNote list = digui(root, i);
//		 
//
//		 System.out.println(list.toString());
		// List<Integer> list2 = getListValue(list);
		// System.out.println(list2.toString());
		// int n = 197;
		// DeptNote deptNote =digui(list, n);
		// System.out.println(deptNote.toString());
		// DeptNote d = aa(root, list);
		// System.out.println("d:" + d.toString());

		// List<Integer> aa = getListValue(list);
		// System.out.println(aa.toString());
		// List<Integer> list = getListPid(baseDepartments, 2);
		// System.out.println(list.toString());
//		 List<Integer> list = getTwoDepartment(baseDepartments);
//		 System.out.println(list);
//		 BaseDepartment department =new BaseDepartment();
//		 department.setDepartment("运营服务组");
//		 department.setpId(70);
//		 BaseDepartment s = StringToDepartName(baseDepartments, department);
//		 System.out.println(s.toString());
	}
}
