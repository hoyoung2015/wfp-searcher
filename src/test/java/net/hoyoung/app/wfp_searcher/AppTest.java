package net.hoyoung.app.wfp_searcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        String s = "<p class=\"c-author\">欧浦钢网&nbsp;&nbsp;2015年08月06日 10:19</p>项目集高效节能和低污染排放于一体,对冶金行业绿色、可持续发展具有积极推动作用。 此外,由";
        
        System.out.println(s.replaceAll("(^(<p).*</p>)", ""));
        
        String ss = s.replaceAll("^(<p).*(p>)$", "");
        
        Pattern pat = Pattern.compile("<(\\S*?) [^>]*>.*?</\\1>|<.*?/>");
       Matcher a = pat.matcher(s);
        for(int i=0;i<a.groupCount();i++){
        	 System.out.println(a.group(i));
        }
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
