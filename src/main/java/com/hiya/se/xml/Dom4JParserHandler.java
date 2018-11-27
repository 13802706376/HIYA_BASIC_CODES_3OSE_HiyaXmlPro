package com.hiya.se.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4JParserHandler implements IParserHandler
{
    @Override
    public void parse(String path)
    {
        SAXReader reader = new SAXReader();
        try
        {
            Document document = reader.read(new File(path));
            Element bookStore = document.getRootElement();
            Iterator<?> it = bookStore.elementIterator();
            while (it.hasNext())
            {
                Element book = (Element) it.next();
                @SuppressWarnings("unchecked")
                List<Attribute> bookAttrs =book.attributes();
                for (Attribute attr : bookAttrs)
                {
                    System.out.println("属性名：" + attr.getName() + "--属性值：" + attr.getValue());
                }
                Iterator<?> itt = book.elementIterator();
                while (itt.hasNext())
                {
                    Element bookChild = (Element) itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
            }
        } catch (DocumentException e)
        {
            e.printStackTrace();
        }
    }

}
