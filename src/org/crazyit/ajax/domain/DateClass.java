package org.crazyit.ajax.domain;
public class DateClass {
	
		static private Integer thursday = 0;
		static private Integer friday = 0;
		
		public DateClass() {
			
			}
			
		public Integer getThursday() {
			
				return thursday;
			}
			
		public Integer getFriday() {
			
				return friday;
			}
			
		public void reset() {
			
				thursday = 0;
				friday = 0;
			}
			
		public void count(String week) {
			
				if(week == "thursday" || week.equals("thursday")) {
						thursday += 1;
					}
					else if(week == "friday" || week.equals("friday")) {
						
							friday += 1;
						}
			}
	}