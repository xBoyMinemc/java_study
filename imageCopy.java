import java.io.*;




public class imageCopy {
	public static void main(String[] args){
		FileCopy copy1 = new FileCopy("C:\\Users\\101\\Desktop\\a.png","C:\\Users\\101\\Desktop\\b.png");
				 copy1.doCopy();
	}
}





class FileCopy{
	String fromPath;
	String toPath;
	
	FileCopy(String from,String to){
		fromPath = from;
		toPath = to;
	}
	
	public void doCopy(){
		BufferedOutputStream to = null; 
		BufferedInputStream from = null;
		int bit;
		try{
		
			to = new BufferedOutputStream(new FileOutputStream(toPath));
			from = new BufferedInputStream(
											new FileInputStream(
												new File(fromPath)
											)
										);
			while((bit = from.read())!=-1)to.write(bit);
		}catch(FileNotFoundException e){e.printStackTrace();}
		 catch(IOException e){e.printStackTrace();}
		 finally{
		 try{
			from.close();
			to.flush();
		 }
		 catch(IOException e){e.printStackTrace();}
		}
									
	}
	
	
	

}