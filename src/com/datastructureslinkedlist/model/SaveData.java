package com.datastructureslinkedlist.model;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



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
				buferW.write("		\"nodeData\":\""+node.getNodeData()+"\"\n");
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
	
	public static NodeList readAll()
	{		
		NodeList nodeList = new NodeList();
			String nodesData;
			try {
				nodesData = Files.readString(Path.of(System.getProperty("user.dir")+"\\nodes.json"));
				if(nodesData == null || nodesData.isEmpty())
				{
					return null;
				}
				else
				{
					String[] separateNodes = nodesData.split("\\{"); //split strings by {
					Pattern pattern = Pattern.compile("\"nodeData\":\"(.*?)\""); //get the pattern nodeData:everything
					Matcher matcher = null;
					
					for (int i = 0; i < separateNodes.length; i++) 
					{
						matcher = pattern.matcher(separateNodes[i]);//search the pattern and store the values
						if (matcher.find())
						{
						    nodeList.add(matcher.group(1)); //get only the data from the search and store it in a node inside the nodeList
						}	
					}				
					return nodeList;
				}						
			} catch (Exception e) {
				
				return null;
			}
									
	}
}
