import java.net.*;	//Provides the classes for implementing networking applications.
import java.io.*;  	// used to process the input and produce the output


public class Server {
	public static void main(String args[])throws Exception{  
		ServerSocket ss=new ServerSocket(3333);  //Creating Server Socket 
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  // get the input stream of the process 
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=din.readUTF();  
			System.out.println("client says: "+str);  
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}}   
	


