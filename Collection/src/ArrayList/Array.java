package ArrayList;

public class Array {

	public static void main(String[] args) {
		
Array call=new Array();
//call.arr();
call.Changevalu();
	
	}
	
		public  void arr() {

			int []num= {22,33,44,5,4,5432,23,12};

			for(int i=0;i<num.length;i++) {
				int n=	num[i];
				System.out.println(n);
			}
				//System.out.println(num[7]);
		}
				
				public void name() {
		String [] nam=new String[4] ;
		nam[0]="ammu";
		nam[1]="ShreeDevi";
		nam[2]="Ravinatantan";
		nam[3]="Juhichawla";
		
		for(int r=0;r<4;r++) {
		String namee=	nam[r];
		System.out.println(namee);
		}
		System.out.println(nam[4]);
		
			}
				
				
				public void Changevalu() {
					
					int [] num=new int[8];
					
					num[0]=33;
					num[2]=90;		
					num[1]=23;
					num[5]=43;
					num[2]=22;
					for(int i=0; i<num.length; i++) {
					System.out.println(num[i]);
					
					}
				}
	}


