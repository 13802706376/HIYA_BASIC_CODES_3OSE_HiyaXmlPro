package com.hiya.se.xml;

public class ParserHandlerClient
{
    public static void main(String[] args)
    {
           String path = "bookstore.xml";
           ParserHandlerContext.parse(new Dom4JParserHandler(), path);
           ParserHandlerContext.parse(new DomParserHandler(), path);
           ParserHandlerContext.parse(new JDomParserHandler(), path);
           ParserHandlerContext.parse(new SAXParserHandler(), path);
    }
}
