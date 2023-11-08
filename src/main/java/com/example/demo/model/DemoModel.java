package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DemoModel {
		@Id
		@GeneratedValue
		private int id;
		private String empId;
		private String empName;

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + "]";
		}

	}

