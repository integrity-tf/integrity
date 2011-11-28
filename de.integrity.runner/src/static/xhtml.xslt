<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet id="xhtmltransform" version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"/>
    
    <xsl:template match="integrity">
    	<html>
			<head>
                <title>
                    <xsl:text>Integration test </xsl:text>
                    <xsl:if test="@name">
                        <xsl:text>'</xsl:text><xsl:value-of select="@name"/><xsl:text>' </xsl:text>
                    </xsl:if>
                    <xsl:text>results - </xsl:text><xsl:value-of select="@timestamp"/><xsl:text> - Integrity test framework</xsl:text>
                </title>
                <style type="text/css">
                    body { color: #000; background-color: #FFF; font-family: Verdana, Geneva, sans-serif; font-size:12px; }
					.pagetitle { font-size: larger; font-weight: bold; }
					.pagesubtitle { font-weight: bold; }
					#header { margin-bottom: 20px; }
					.box { border: solid 1px; margin-top: 10px; }
					.boxtitle { color: #FFF; font-weight: bold; padding: 2px 2px 2px 2px; position: relative; left: 0px; top: 0px; border: none; }
					.boxtitleright { position: absolute; right: 2px; }
					.boxcontent { padding: 10px 10px 10px 10px; }
					table { border-spacing: 0px; margin-bottom: 2px; border-bottom: 1px solid #000; }
					table th { border-bottom: 1px solid #000; padding-left: 4px; }
					table td { padding-left: 4px; padding-bottom: 2px; padding-top: 2px; }
					.variabletable th { font-size: smaller; }
					.variabletable .row1 { background-color: #D0CCFF; }
					.variabletable .row2 { background-color: #E7E6FF; }
					.sectionTitle { font-size: small; font-weight: bold; margin-bottom: 0px; margin-top: 8px; border-bottom: 2px solid #000; }
					.test { border: 1px solid #FFF; position: relative; top: 0px; left: 0px; margin-bottom: 1px; padding-left: 40px; padding-right: 4px; }
					.test:hover { border: 1px dashed #000; }
					.testicon { font-size: 30px; margin-left: 8px; position: absolute; left: 0px; }
					.testdescription { padding-left: 4px; padding-top: 4px; padding-bottom: 4px; }
					.row1testsuccess { background-color: #BEFFBB; }
					.row2testsuccess { background-color: #E8FFE6; }
					.row1callsuccess { background-color: #DDDDDD; }
					.row2callsuccess { background-color: #EEEEEE; }
					.row1testfailure { background-color: #FF9B9B; }
					.row2testfailure { background-color: #FFC4C4; }
					.row1exception { background-color: #FFE6B7; }
					.row2exception { background-color: #FFF7E8; }
					.row1callexception { background-color: #FFE6B7; }
					.row2callexception { background-color: #FFF7E8; }
					.testresults { font-size: smaller; font-weight: bold; padding: 4px; }
					.testResultValue { font-weight: bold; }
					.testResultValueSuccess { color: #063; }
					.testResultValueFailure { color: #C00; }
					.testduration { font-size: smaller; position: absolute; top: 2px; right: 4px; color: #555; }
					.parametertable th { font-size: smaller; }
					.exceptiontrace { padding-top: 10px; padding-bottom: 5px; }
					.tab { padding-right: 20px; }
					.fixturename { font-size: smaller; padding: 4px; }
                </style>
			</head>
			<body>
	        	<div id="header">
                	<h1 class="pagetitle">Integration test results</h1>
                    <xsl:if test="@name">
	                    <div align="left" class="pagesubtitle">Test: <xsl:value-of select="@name"/></div>
                    </xsl:if>
                    <div align="left" class="pagesubtitle">Started: <xsl:value-of select="@timestamp"/></div>
                    <div align="left" class="pagesubtitle">Duration: <xsl:call-template name="duration"><xsl:with-param name="value" select="@duration"/></xsl:call-template></div>
            	</div>
                <xsl:if test="count(variables/variable) > 0">
                	<xsl:call-template name="variablebox"/>
                </xsl:if>
                <xsl:apply-templates select="suite"/>
	        </body>
		</html>
	</xsl:template>
    
    <xsl:template match="variables">
        <table class="variabletable" width="100%">
            <tr>
                <th width="300px" align="left">Name</th>
                <th align="left">Initial Value</th>
            </tr>
            <xsl:for-each select="variable">
                <xsl:variable name="class">
                    <xsl:choose>
                        <xsl:when test="position() mod 2 = 1">
                            <xsl:text>row1</xsl:text>
                        </xsl:when>
                        <xsl:otherwise>row2</xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <tr><xsl:attribute name="class"><xsl:value-of select="$class"/></xsl:attribute>
                    <td><xsl:value-of select="@name"/></td>
                    <td><xsl:if test="@value"><xsl:value-of select="@value"/></xsl:if></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    
    <xsl:template name="variablebox">
    	<xsl:call-template name="box">
        	<xsl:with-param name="color">#5966FF</xsl:with-param>
            <xsl:with-param name="title">Global Variables</xsl:with-param>
            <xsl:with-param name="content">
            	<xsl:apply-templates select="variables"/>
            </xsl:with-param>
        </xsl:call-template>    
    </xsl:template>
    
    <xsl:template match="suite">
    	<xsl:variable name="result">
        	<xsl:choose>
                <xsl:when test="result/@exceptionCount > 0">exception</xsl:when>
                <xsl:when test="result/@failureCount > 0">failure</xsl:when>
                <xsl:otherwise>success</xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
		<xsl:call-template name="box">
        	<xsl:with-param name="color">
            	<xsl:choose>
                	<xsl:when test="$result = 'success'">#009933</xsl:when>
                    <xsl:when test="$result = 'exception'">#F99500</xsl:when>
                    <xsl:when test="$result = 'failure'">#CA0005</xsl:when>
            	</xsl:choose>
            </xsl:with-param>
            <xsl:with-param name="title"><xsl:value-of select="@name"/></xsl:with-param>
            <xsl:with-param name="titleRight">
            	<xsl:if test="result/@successCount > 0"><xsl:value-of select="result/@successCount"/>✔</xsl:if>
                <xsl:if test="result/@failureCount > 0"><xsl:if test="result/@successCount > 0"> </xsl:if><xsl:value-of select="result/@failureCount"/>✘</xsl:if>
                <xsl:if test="result/@exceptionCount > 0"><xsl:if test="result/@successCount > 0 or result/@failureCount > 0"> </xsl:if><xsl:value-of select="result/@exceptionCount"/>⚠</xsl:if>
                <xsl:if test="result/@successCount > 0 or result/@failureCount > 0 or result/@exceptionCount > 0"><xsl:text> </xsl:text> in <xsl:text> </xsl:text></xsl:if>
            	<xsl:call-template name="duration"><xsl:with-param name="value" select="result/@duration"/></xsl:call-template>
            </xsl:with-param>
            <xsl:with-param name="content">
            	<xsl:if test="count(variables/variable) > 0">
                	<div class="sectionTitle">Variables</div>
	            	<xsl:apply-templates select="variables"/>
                </xsl:if>
            
            	<xsl:if test="count(setup/suite) > 0">
                	<div class="sectionTitle">Setup</div>
                    <xsl:apply-templates select="setup/suite" />
                </xsl:if>
                
                <xsl:if test="count(variables/variable) > 0 or count(setup/suite) > 0 or count(teardown/suite) > 0">
                	<div class="sectionTitle">Suite</div>
                </xsl:if>
                
                <xsl:apply-templates select="statements/*"/>
                
                <xsl:if test="count(teardown/suite) > 0">
                	<div class="sectionTitle">Teardown</div>
                    <xsl:apply-templates select="teardown/suite" />
                </xsl:if>
            </xsl:with-param>
        </xsl:call-template>
    </xsl:template>
    
    <xsl:template match="test|call">
    	<div onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
        	<xsl:attribute name="class"><xsl:text>test row1</xsl:text><xsl:value-of select="name()"/><xsl:value-of select="result/@type"/></xsl:attribute>
            <xsl:if test="name() = 'test'">
                <span class="testicon">
                    <xsl:if test="result/@type = 'success'">✔</xsl:if>
                    <xsl:if test="result/@type = 'failure'">✘</xsl:if>
                    <xsl:if test="result/@type = 'exception'">⚠</xsl:if>
                </span>
            </xsl:if>
            <xsl:if test="name() = 'call' and result/@type = 'exception'">
            	<span class="testicon">⚠</span>
            </xsl:if>
            <div class="testdescription">
            	<xsl:value-of select="@description"/>
            </div>
            <div class="testparameters" style="display: none;">
            	<div class="fixturename"><xsl:value-of select="@fixture"/></div>
            	<xsl:if test="count(parameters/parameter) > 0">
                    <table class="parametertable" width="100%">
                        <tr>
                            <th width="200px" align="left">Parameter</th>
                            <th align="left">Value</th>
                        </tr>
                        <xsl:for-each select="parameters/parameter">
                            <xsl:variable name="class">
                                <xsl:choose>
                                    <xsl:when test="position() mod 2 = 1">
                                        <xsl:text>row1</xsl:text>
                                    </xsl:when>
                                    <xsl:otherwise>row2</xsl:otherwise>
                                </xsl:choose>
                                <xsl:value-of select="name(../parent::*)"/>
                                <xsl:value-of select="../../result/@type"/>
                            </xsl:variable>
                            <tr><xsl:attribute name="class"><xsl:value-of select="$class"/></xsl:attribute>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:if test="@value"><xsl:value-of select="@value"/></xsl:if></td>
                            </tr>
                        </xsl:for-each>
                    </table>
				</xsl:if>
				<xsl:if test="result/@exceptionTrace">
	            	<div class="exceptiontrace">
	            		<xsl:call-template name="formatExceptionTrace">
	              			<xsl:with-param name="text" select="result/@exceptionTrace" />
	              		</xsl:call-template>
	            	</div>
	          	</xsl:if>
            </div>
            <div class="testresults">
            	<xsl:if test="result/@type = 'success'">result: <span class="testResultValue testResultValueSuccess"><xsl:value-of select="result/@value"/></span></xsl:if>
                <xsl:if test="result/@type = 'failure'">result: <span class="testResultValue testResultValueFailure"><xsl:value-of select="result/@value"/></span>, but expected: <span class="testResultValue"><xsl:value-of select="result/@expectedValue"/></span></xsl:if>
                <xsl:if test="result/@type = 'exception'"><xsl:value-of select="result/@exceptionMessage"/></xsl:if>
            </div>
            <span class="testduration">
            	<xsl:call-template name="duration"><xsl:with-param name="value" select="result/@duration"/></xsl:call-template>
            </span>
        </div>
    </xsl:template>
    
    <xsl:template name="box">
    	<xsl:param name="class"/>
        <xsl:param name="color"/>
    	<xsl:param name="title"/>
        <xsl:param name="titleRight"/>
        <xsl:param name="content"/>
        <div><xsl:attribute name="class">box<xsl:if test="$class"> <xsl:value-of select="$class"/></xsl:if></xsl:attribute><xsl:attribute name="style">border-color: <xsl:value-of select="$color"/>;</xsl:attribute>
        	<div class="boxtitle" onClick="var div=this.parentNode.getElementsByTagName('div')[1]; if(div.style.display!='none') div.style.display='none'; else div.style.display='block';" onMouseOver="this.parentNode.style.borderStyle='dashed'; this.parentNode.style.borderColor='#000';"><xsl:attribute name="onMouseOut"><xsl:text>this.parentNode.style.borderStyle='solid'; this.parentNode.style.borderColor='</xsl:text><xsl:value-of select="normalize-space($color)"/><xsl:text>';</xsl:text></xsl:attribute><xsl:attribute name="style">background-color: <xsl:value-of select="normalize-space($color)"/>;</xsl:attribute>
                <span class="boxtitleleft"><xsl:value-of select="$title"/></span>
                <xsl:if test="$titleRight"><span class="boxtitleright"><xsl:value-of select="$titleRight"/></span></xsl:if>
            </div>
            <div class="boxcontent">
	        	<xsl:copy-of select="$content"/>
            </div>
        </div>
    </xsl:template>
    
    <xsl:template name="duration">
    	<xsl:param name="value"/>
        <xsl:variable name="hours"><xsl:value-of select="floor($value div 3600000)"/></xsl:variable>
        <xsl:variable name="minutes"><xsl:value-of select="floor(($value mod 3600000) div 60000)"/></xsl:variable>
        <xsl:variable name="seconds"><xsl:value-of select="floor(($value mod 60000) div 1000)"/></xsl:variable>
        <xsl:variable name="msecs"><xsl:value-of select="round($value mod 1000)"/></xsl:variable>
        <xsl:if test="$hours > 0"><xsl:value-of select="$hours"/>h</xsl:if>
        <xsl:if test="$minutes > 0"><xsl:if test="$hours > 0"><xsl:text> </xsl:text></xsl:if><xsl:value-of select="$minutes"/>m</xsl:if>
        <xsl:if test="$seconds > 0"><xsl:if test="$hours > 0 or $minutes > 0"><xsl:text> </xsl:text></xsl:if><xsl:value-of select="$seconds"/>s</xsl:if>
        <xsl:if test="$msecs > 0">
        	<xsl:choose>
        		<xsl:when test="$hours > 0 or $minutes > 0 or $seconds > 0">
    	        	<xsl:text> </xsl:text><xsl:value-of select="$msecs"/>ms
	            </xsl:when>
            	<xsl:otherwise>
                	<xsl:value-of select="$value"/>ms
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:template>
    
    <xsl:template name="formatExceptionTrace">
	   <xsl:param name="text"/>
	   <xsl:choose>
	     <xsl:when test="not(contains($text, '&#xA;'))">
	       <xsl:copy-of select="$text"/>
	     </xsl:when>
	     <xsl:otherwise>
	       <xsl:value-of select="substring-before($text, '&#xA;')"/>
	       <br /><span class="tab"/>
	       <xsl:call-template name="formatExceptionTrace">
	         <xsl:with-param name="text" select="substring-after($text, '&#xA;')"/>
	       </xsl:call-template>
	     </xsl:otherwise>
	   </xsl:choose>
	</xsl:template>
    
</xsl:stylesheet>