import java.net.*;	//Provides the classes for implementing networking applications.
import java.io.*;  	//used to process the input and produce the output

public class Client {

	public static void main(String args[])throws Exception{  
		Socket s=new Socket("localhost",3333);  //Creating client Socket 
		DataInputStream din=new DataInputStream(s.getInputStream());   //getInputStream() method gets the input stream of the subprocess & DataInputStream class allows an application to read primitive data from the input stream
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=br.readLine();  
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}  
	  
		dout.close();  
		s.close();  
	}}
