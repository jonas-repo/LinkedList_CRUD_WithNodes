package com.datastructureslinkedlist.model;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;



public class SaveData {

	public static String saveAll(Node node)
	{
		File file = null;
		FileWriter fileW = null;
		BufferedWriter buferW = null;
		
		try {
			
			file = new File(System.getProperty("user.dir")+"\\nodes.json");
			fileW = new FileWriter(file);
			buferW = new BufferedWriter(fileW); 
			int count = 0;
			
			buferW.write("[ \n");
			while(node != null)
			{
				buferW.write("	{ \n");
				buferW.write("		\"Node"+count+"\":\""+node.getNodeData()+"\"\n");
				if(node.hasNextNode())
				{
					buferW.write("	},\n");
				}
				else
				{
					buferW.write("	}\n");
				}
				
				node = node.getNextNode();
				count++;
			}
			buferW.write("]");
			  
			if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
			{  
			System.out.println("not supported");  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(file.exists()) 
			{         //checks file exists or not  
			desktop.open(file);              //opens the specified file  
			}  
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			file =  null;
			fileW = null;
			try 
			{
				buferW.close();  //to write in the archive we have to close the buffer writer
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			};

		}
		
		return "Saved in: "+System.getProperty("user.dir");
	}
	
}
