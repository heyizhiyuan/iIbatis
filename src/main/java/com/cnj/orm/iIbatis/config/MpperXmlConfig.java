package com.cnj.orm.iIbatis.config;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.cnj.orm.iIbatis.mapping.MappedStatement;

public class MpperXmlConfig {
	
	@SuppressWarnings("static-access")
	public static Map<String,MappedStatement> loadMapperXml(String mapperPath) {
		URL url=MpperXmlConfig.class.getClassLoader().getSystemResource(mapperPath);
		File root=new File(url.getFile());
		Set<String> paths=new HashSet<String>();
		loadXmlPaths(root,paths);
		return parseXmlToHashMap(paths);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,MappedStatement> parseXmlToHashMap(Set<String> paths) {
		SAXReader reader=new SAXReader();
		Map<String,MappedStatement> msMap=new HashMap<>();
		for (String path: paths) {
			try {
				Document doc= reader.read(path);
				Element root=doc.getRootElement();
				String nameSpace=root.attributeValue("namespace");
				List<Element> eles=root.elements();
				for (Element e : eles) {
					MappedStatement ms=new MappedStatement();
					String id=e.attributeValue("id");
					ms.setId(id);
					ms.setNameSpace(nameSpace);
					ms.setParameterType(e.attributeValue("parameterType"));
					ms.setResultType(e.attributeValue("resultType"));
					ms.setSql(e.getTextTrim());
					msMap.put(nameSpace+"."+id,ms);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
		}
		return msMap;
		
	}

	private static void loadXmlPaths(File root,Set<String> paths) {
		root.listFiles((File dir)->{
			if(dir.isDirectory()) {
				loadXmlPaths(new File(dir.getAbsolutePath()), paths);
				return false;
			}else if(dir.getName().endsWith(".xml")) {
				paths.add(dir.getAbsolutePath());
				return true;
			}
			return false;
		});
	}


	@Test
	public void test01() {
		long start =System.currentTimeMillis();
		loadMapperXml("mapper");
		System.out.println(System.currentTimeMillis()-start);
	}
	

}
