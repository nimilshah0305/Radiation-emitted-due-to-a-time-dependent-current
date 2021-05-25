import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class lcs {
	public static void main (String[] args){
		
		try {
			FileInputStream file = new FileInputStream(args[0]);
			DataInputStream data = new DataInputStream (file);
			BufferedReader line= new BufferedReader(new InputStreamReader (data));
			String Line;
			int locationX=0;
			int locationY=0;
			char[] line1 = null;
			char []line2=null;
			ArrayList list=new ArrayList();
			ArrayList collectData=new ArrayList();
			String tempString;
			
			while ((Line = line.readLine())!=null){
				collectData.add(Line);
			}
			while (collectData.size()>0){
				tempString = (String) collectData.get(0);
				tempString=tempString+";"+(String)collectData.get(1);
				list.add(tempString);
				tempString="";
				collectData.remove(0);
				collectData.remove(0);
			}
				
			while (list.size()>0){
				Line=(String) list.get(0);
				list.remove(0);
				if (Line.length()>0){
		char[] lineBuff;
		String line1Buff = "";
		String line2Buff="";
		int position=0;
		int Best=0;
				lineBuff=Line.toCharArray();
				if (exitCondition(lineBuff)==false){
					while (lineBuff[position] !=';'){						
						line1Buff= line1Buff+Character.toString(lineBuff[position]);
						line1=line1Buff.toCharArray();
						position++;
					}
				
				if (lineBuff[position]==';'){
					position ++;
				}
					while (position< lineBuff.length){
						line2Buff=line2Buff+Character.toString(lineBuff[position]);
						line2=line2Buff.toCharArray();
						position++;
					}
				
				int l1= line1.length;
				int l2 = line2.length;
				
				int [][] matrix = new int[l1][l2];
				for (int matrixL1=0;matrixL1<l1;matrixL1++){
					for (int matrixL2=0;matrixL2<l2;matrixL2++){
						if (matrixL1==0||matrixL2==0){
							if (line1[matrixL1]==line2[matrixL2]){
								matrix [matrixL1][matrixL2]=1;
							}
							if (line1[matrixL1]!=line2[matrixL2]){
								matrix[matrixL1][matrixL2]=0;
							}
						}
						
						if (matrixL1>0 & matrixL2>0){
							if (line1[matrixL1]==line2[matrixL2]){
								matrix [matrixL1][matrixL2]=matrix[matrixL1-1][matrixL2-1]+1;
							}
							
							if (line1[matrixL1]!=line2[matrixL2]){
								matrix[matrixL1][matrixL2]=0;
							}
						}
					
					
					}
				}
				for (int i =0; i < l1; i++) {
				for (int j = 0; j < l2; j++) {
					
					if (matrix[i][j]>=Best){
						Best=matrix[i][j];
					}	
				}
				}
				String common="";
				if (Best>0){
					
				for (int i =0; i < l1; i++) {
					for (int j = 0; j < l2; j++) {
						if (matrix[i][j]==Best){
							locationX=i;
							locationY=j;
							int insertX=locationX-Best+1;
							int insertCommon =0; 
							if (Best>0){
							while (insertCommon<Best){
								common = common + Character.toString(line1[insertX]);
								insertX++;
								insertCommon++;
							}
							}
						}
							
						}		
				}
				System.out.print(common.length()+"\n");	
				}
				if (Best==0){
				}
			
			}
				if ((exitCondition(lineBuff)==true)){
				}
			
		}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			System.out.println("\n\n\nAGAR APKO LAGTA HAI KI YE CODE AASANI SE MIL JAEGA... TO HO SAKTA HAI AAP GALAT HO..!!!!\n\n\n");
		}
	}

	private static boolean exitCondition(char[] lineBuff) {
		for (int checkChar =0; checkChar< lineBuff.length;checkChar++){
			boolean found = false;
			if (lineBuff[0]==';' || lineBuff[lineBuff.length-1]==';'){
				return true;
			}
			if (checkChar>0&&checkChar<lineBuff.length-1){
				if (lineBuff[checkChar]==';'){
					return false;
				}
			}	
		}
		
		return true;
	}
	
}
