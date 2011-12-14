<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" id="xhtmltransform" version="1.0">
    <xsl:output method="html" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" />
    <xsl:template match="integrity">
      <html>
        <head>
          <title>
            <xsl:text>Integration Test '</xsl:text>
            <xsl:if test="@name">
              <xsl:value-of select="@name" />
            </xsl:if>
            <xsl:text>' Results (</xsl:text>
            <xsl:value-of select="@timestamp" />
            <xsl:text>) - Integrity Test Framework</xsl:text>
          </title>
          <style type="text/css">
            body { color: #000; background-color: #FFF; font-family: Helvetica, Arial, sans-serif; font-size:12px; }
            .pagetitle { font-size: larger; font-weight: bold; }
            .pagesubtitle { font-weight: bold; }
            #header { margin-bottom: 20px; background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAA8CAMAAAAUhQWjAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAJBQTFRF////AAAAREREu7u7iIiIurq6d3d3Q0ND7u7uERERh4eHMzMzzMzMqqqq3d3dIiIi9/f3PDw8xMTEZmZmkZGRmZmZJSUlTU1NVVVVNjY2gICAs7Oz5OTkAwMDXl5eb29vWFhY09PT1dXVEBAQISEh7e3t3NzcR0dHdnZ2VFRUoqKi9fX1FBQU5ubmqampZWVloemuYgAABx1JREFUeNrsWtl64joMthxD43EWIATC0tKNdqZzlvd/uyPJdlYIlNDOzPmqC5rYluxflmTJqRBf9EX/f5qMRqPJQBmb7zfH6Pvmk3DMFgCwGDbbPfTRfa8WJ9fCASClBNgMkL4DrYJjpDTsjnLOF7CYXwfIGsb4q+D75dInC4h6uiNYHNPLHLUIcB0kNxDgbwA3l0sfgeztlzA60jOFWMQwvQqQHyirCeTd0i8HAuB/htMcJBqyhPXl0l8g7e1P4YWHsee9YIx88TbppsKmqBlFqzFMe2rZ09+9qETtG3wvC44slRkfkL6P+uPAFLIeHBnv7vYVJ5ltpjzbdO180U5FtHLR5ufdM9TGEG2XtmV5b0OgFTWzrc93P2nMw9SJmdU8vSWd5Pj+w3Hg4Ra09JRzU16+a7h9wIYlpJJEptiU8nrIF8kmeZRxcfNhwVGUxyy3/nzQVhD+1ei8XpS2fIstx5vUiZlVnt6SvgTt+4/FAa8PojG3jKuGKeGYPEGIjVpxb0Ah2XqnJxs3USUyEX7MipBscM6QGsIxxiV0XicKxtyaSFjV3HTsfaQr3fGt++MAWzHStxLIN9eyrwJC4BeJIfmvv2289BTDDyEeb2tGGhpa4sarhrbZ2jyLgrwaNhd+2ipqdaU7vpvz4kANSDeysQoxtOBvAf+swajANuCxScvBzSccCTWEbolLoE2MgiDyoYhFRZEdmNAil3is63FMQ0ogXelXBEIrQislZVL/CmruSNrnzRc5v+qIl2ibFLVkdSDWXoDiZQhPLkmS9XOkIz0C434I9zAgaOawuqEh3L9xU/nU0uqa329oKlxi1XQLJmwAybC10uzs248mkI508Qy4fwbehLijJfSflb1AEgxFO/to+1s77DbfUd0hcHUPK1amB4J2d7tBp83LBY1aQDr2w8vPcTS6YkLn9PxSIDjLzD3aIPUeIGJbb0KdrDAavgEYH0ZPArEGlcJsTWbakwKeA6T5eAhIM4U54KG+iU+ZtxWs5uI8ILx/uLLlgiJa1pOUDwAyoZykH8i6u0kcPg5M0QYysRnPG8cGzVEhgdvHDwBC1d3rtg1kDFM3eDUa3XO06wIRp4FY6e4cpLM0pw25E9cHQtVdCq9NHyGacbgMDQfkQFwGxEm3GTLthd2Xx+sD4cQmTJ0b6yq5mVG4RNsJMymLRPQBmS+fnBrM7rEBxEt/8SVgpthTxFAgnF7bR47sBWmbw+GIT7+oQoLp5o6PRpeNHAdSHYjEZpG0pXNRbo9V3JDZYCCiAnIHqhyRwPNk2agHIi4A7kskoTkKBCNrHFZsa3duNKUL4U4Qiv4nNuQoELZ1TgzrQDY1dRfofY2k0RsHKntMCVOeWlOpi2pP20gc29ItuMzWepsLgWDqE4SFPbqmqCmXTqO6x6yiWGI+zGm8SepRy17SNM7IuqhqR9KSLSxT+bZ04fPr/HQlfxTImhZipW1sQGrdiC0euLJZNa7E7KDZmrKvfz2QmqiSXg+wdaV720op4boQiFjfPLmST2DBO/VzzWxpO51PWqWui1o49864d+NS3ZooTzW2p2Xlx03pG3rLxFlXK8eBXEqoQ0eSc/zlxZKsJZxMFz8KCGZ41d1HcoZR9NwjqsQGg8XkFwCp16x4xLxeLKhMgOp3X5+7I+6ESDBLuv8pBuwIqyQ/Z0M+1EcA+jPv0ypxdI51Xh+IeMQsyt3FzQZuLt9aTc/ysh4gSTBkEVH0udw9QFTjpkmo8Bx5oSpvwnsXGg/hfu+OqGb1d9YGBX4FQdw3TMkh3O8DEijegziK+EFBphiZsu2hUkkeijhJ3DilsI5LMlCKFpHbwSKyryqMVU0vgUyViqpulEHdbW4/NwrPk/hSIJi40R5Ig+VagaUSGEnSTSoN1guJNlLjACm1MZJ1LLUSkQQpeeUG7NUnNuMMYLTUFZI41bKIqu7USITW4XZzi7GWyHB51HJAIhHo0rQCKqWMwqkowCMQrKcj7eylqBuHXQpfrCFzEXJ3y7S4G7lTGXAV1uZ2c2PlHprBQJQT64GgEaDyeCUExNUVufYVX3MpjpuY637hgUilMqDSWKe5OJt7MJCQHun7RVztiLMX+kxcOCDheUBwmKSPJIWNV1od5z6+I2Wm3f0+YnalVsjRSiC4VHxOQPFFe5Iao5tAYsPXvkFA1yehDd6ZCYIsPQDEBDnY7iDEwfgnKzrcfm6FDnbQR7b1aqjzocd+r+EWZC4Ulf7WeKiqYxtSNmrhbIUqTUvTUoiNpjRuVIGaQdx8V1/zkVDabvqSpfl+G9Kow13OjVHroGktWfixs8qcW0KEMOjsfx+NDwDZg+47pUMN+9OCMdym5pNARIWUEF/zO3uNcqXUZ+0GnZeR+CAgvwNdxbR+C7qSs/962q56/19rtRV/DNUOxDaZnfiiL/qiL/pd6D8BBgCtDV//TkdTmwAAAABJRU5ErkJggg=="); background-repeat: no-repeat; background-position: 0px 0px; padding-left: 220px; padding-top: 6px; min-height: 60px; line-height: 126%; }
            .box { border: solid 1px; margin-top: 10px; }
            .boxtitle { color: #FFF; font-weight: bold; padding: 2px 2px 2px 2px; position: relative; left: 0px; top: 0px; border: none; }
            .boxtitleright { position: absolute; right: 2px; }
            .boxcontent { padding: 10px 10px 10px 10px; }
            table { border-spacing: 0px; margin-bottom: 2px; border-bottom: 1px solid #000; }
            table th { border-bottom: 1px solid #000; padding-left: 4px; }
            table td { padding-left: 4px; padding-bottom: 2px; padding-top: 2px; }
            .variabletable th { font-size: 8pt; }
            .variabletable .row1 { background-color: #D0CCFF; }
            .variabletable .row2 { background-color: #E7E6FF; }
            .sectionTitle { font-size: small; font-weight: bold; margin-bottom: 0px; margin-top: 8px; border-bottom: 2px solid #000; }
            .statement { border: 1px solid #FFF; position: relative; top: 0px; left: 0px; margin-bottom: 1px; padding-left: 40px; padding-right: 4px; }
            .statement:hover { border: 1px dashed #000; }
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
            .row1testexception { background-color: #FFE6B7; }
            .row2testexception { background-color: #FFF7E8; }
            .row1callexception { background-color: #FFE6B7; }
            .row2callexception { background-color: #FFF7E8; }
            .testresults { font-size: 8pt; font-weight: bold; padding: 4px; }
            .testResultValue { font-weight: bold; }
            .testResultValueSuccess { color: #063; }
            .testResultValueFailure { color: #C00; }
            .testduration { font-size: 8pt; position: absolute; top: 2px; right: 4px; color: #555; }
            .parametertable th { font-size: 8pt; }
            .resultstable th { font-size: 8pt; }
            .exceptiontrace { padding-top: 10px; padding-bottom: 5px; }
            .tab { padding-right: 20px; }
            .fixturename { font-size: 8pt; padding: 4px; }</style>
        </head>
        <body>
          <div id="header">
            <xsl:if test="@name">
              <div align="left" class="pagesubtitle">
                Test:
                <xsl:value-of select="@name" />
              </div>
            </xsl:if>
            <div align="left" class="pagesubtitle">
              Started:
              <xsl:value-of select="@timestamp" />
            </div>
            <div align="left" class="pagesubtitle">
              Duration:
              <xsl:call-template name="duration">
                <xsl:with-param name="value" select="@duration" />
              </xsl:call-template>
            </div>
          </div>
          <xsl:if test="count(variables/variable) &gt; 0">
            <xsl:call-template name="variablebox" />
          </xsl:if>
          <xsl:apply-templates select="suite" />
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
          <tr>
            <xsl:attribute name="class">
              <xsl:value-of select="$class" />
            </xsl:attribute>
            <td>
              <xsl:value-of select="@name" />
            </td>
            <td>
              <xsl:if test="@value">
                <xsl:value-of select="@value" />
              </xsl:if>
            </td>
          </tr>
        </xsl:for-each>
      </table>
    </xsl:template>
    <xsl:template name="variablebox">
      <xsl:call-template name="box">
        <xsl:with-param name="color">#5966FF</xsl:with-param>
        <xsl:with-param name="title">Global Variables</xsl:with-param>
        <xsl:with-param name="content">
          <xsl:apply-templates select="variables" />
        </xsl:with-param>
      </xsl:call-template>
    </xsl:template>
    <xsl:template match="suite">
      <xsl:variable name="result">
        <xsl:choose>
          <xsl:when test="result/@exceptionCount &gt; 0">exception</xsl:when>
          <xsl:when test="result/@failureCount &gt; 0">failure</xsl:when>
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
        <xsl:with-param name="title">
          <xsl:value-of select="@name" />
        </xsl:with-param>
        <xsl:with-param name="titleRight">
          <xsl:if test="result/@successCount &gt; 0">
            <xsl:value-of select="result/@successCount" />
            ✔
          </xsl:if>
          <xsl:if test="result/@failureCount &gt; 0">
            <xsl:if test="result/@successCount &gt; 0" />
            <xsl:value-of select="result/@failureCount" />
            ✘
          </xsl:if>
          <xsl:if test="result/@exceptionCount &gt; 0">
            <xsl:if test="result/@successCount &gt; 0 or result/@failureCount &gt; 0" />
            <xsl:value-of select="result/@exceptionCount" />
            ⚠
          </xsl:if>
          <xsl:if test="result/@successCount &gt; 0 or result/@failureCount &gt; 0 or result/@exceptionCount &gt; 0">
            <xsl:text />
            in
            <xsl:text />
          </xsl:if>
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="result/@duration" />
          </xsl:call-template>
        </xsl:with-param>
        <xsl:with-param name="content">
          <xsl:if test="count(variables/variable) &gt; 0">
            <div class="sectionTitle">Variables</div>
            <xsl:apply-templates select="variables" />
          </xsl:if>
          <xsl:if test="count(setup/suite) &gt; 0">
            <div class="sectionTitle">Setup</div>
            <xsl:apply-templates select="setup/suite" />
          </xsl:if>
          <xsl:if test="count(variables/variable) &gt; 0 or count(setup/suite) &gt; 0 or count(teardown/suite) &gt; 0">
            <div class="sectionTitle">Suite</div>
          </xsl:if>
          <xsl:apply-templates select="statements/*" />
          <xsl:if test="count(teardown/suite) &gt; 0">
            <div class="sectionTitle">Teardown</div>
            <xsl:apply-templates select="teardown/suite" />
          </xsl:if>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:template>
    <xsl:template match="call">
      <div onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
        <xsl:attribute name="class">
          <xsl:text>statement row1call</xsl:text>
          <xsl:value-of select="result/@type" />
        </xsl:attribute>
        <xsl:if test="result/@type = 'exception'">
          <span class="testicon">⚠</span>
        </xsl:if>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="testparameters" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
          <xsl:if test="count(parameters/parameter) &gt; 0">
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
                  <xsl:value-of select="name(../parent::*)" />
                  <xsl:value-of select="../../result/@type" />
                </xsl:variable>
                <tr>
                  <xsl:attribute name="class">
                    <xsl:value-of select="$class" />
                  </xsl:attribute>
                  <td>
                    <xsl:value-of select="@name" />
                  </td>
                  <td>
                    <xsl:if test="@value">
                      <xsl:value-of select="@value" />
                    </xsl:if>
                  </td>
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
        <xsl:if test="result/@type != 'success' or result/@value != '(null)'">
	      <div class="testresults">
	        <xsl:if test="result/@type = 'success' and result/@value != '(null)'">
	          result:
	          <span class="testResultValue testResultValueSuccess">
	            <xsl:value-of select="result/@value" />
	          </span>
	        </xsl:if>
	        <xsl:if test="result/@type = 'exception'">
	          <xsl:value-of select="result/@exceptionMessage" />
	        </xsl:if>
	      </div>
	    </xsl:if>
        <span class="testduration">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="result/@duration" />
          </xsl:call-template>
        </span>
      </div>
    </xsl:template>
	<xsl:template match="test">
      <div onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
        <xsl:attribute name="class">
          <xsl:text>statement row1test</xsl:text>
          <xsl:value-of select="results/result/@type" />
        </xsl:attribute>
		<span class="testicon">
			<xsl:if test="results/result/@type = 'success'">✔</xsl:if>
			<xsl:if test="results/result/@type = 'failure'">✘</xsl:if>
			<xsl:if test="results/result/@type = 'exception'">⚠</xsl:if>
		</span>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="testparameters" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
          <xsl:if test="count(results/result/parameters/parameter) &gt; 0">
            <table class="parametertable" width="100%">
              <tr>
                <th width="200px" align="left">Parameter</th>
                <th align="left">Value</th>
              </tr>
              <xsl:for-each select="results/result/parameters/parameter">
                <xsl:variable name="class">
                  <xsl:choose>
                    <xsl:when test="position() mod 2 = 1">
                      <xsl:text>row1</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>row2</xsl:otherwise>
                  </xsl:choose>
                  <xsl:value-of select="name(../parent::*)" />
                  <xsl:value-of select="../../result/@type" />
                </xsl:variable>
                <tr>
                  <xsl:attribute name="class">
                    <xsl:value-of select="$class" />
                  </xsl:attribute>
                  <td>
                    <xsl:value-of select="@name" />
                  </td>
                  <td>
                    <xsl:if test="@value">
                      <xsl:value-of select="@value" />
                    </xsl:if>
                  </td>
                </tr>
              </xsl:for-each>
            </table>
          </xsl:if>
          <xsl:if test="results/result/@exceptionTrace">
            <div class="exceptiontrace">
              <xsl:call-template name="formatExceptionTrace">
                <xsl:with-param name="text" select="results/result/@exceptionTrace" />
              </xsl:call-template>
            </div>
          </xsl:if>
        </div>
        <div class="testresults">
          <xsl:if test="results/result/@type = 'success'">
            result:
            <span class="testResultValue testResultValueSuccess">
              <xsl:value-of select="results/result/comparisons/comparison/@value" />
            </span>
          </xsl:if>
          <xsl:if test="results/result/@type = 'failure'">
            result:
            <span class="testResultValue testResultValueFailure">
              <xsl:value-of select="results/result/comparisons/comparison/@value" />
            </span>
            , but expected:
            <span class="testResultValue">
              <xsl:value-of select="results/result/comparisons/comparison/@expectedValue" />
            </span>
          </xsl:if>
          <xsl:if test="results/result/@type = 'exception'">
            <xsl:value-of select="results/result/@exceptionMessage" />
          </xsl:if>
        </div>
        <span class="testduration">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="results/result/@duration" />
          </xsl:call-template>
        </span>
      </div>
    </xsl:template>
	<xsl:template match="tabletest">
      <div onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
	  	<xsl:variable name="testsuccess">
			<xsl:choose>
				<xsl:when test="results/@successCount &gt; 0 and results/@failureCount = 0 and results/@exceptionCount = 0">success</xsl:when>
				<xsl:when test="results/@failureCount &gt; 0 and results/@exceptionCount = 0">failure</xsl:when>
				<xsl:when test="results/@exceptionCount &gt; 0">exception</xsl:when>
			</xsl:choose>
		</xsl:variable>
        <xsl:attribute name="class">
          <xsl:text>statement row1test</xsl:text>
          <xsl:value-of select="$testsuccess" />
        </xsl:attribute>
		<span class="testicon">
			<xsl:if test="$testsuccess = 'success'">✔</xsl:if>
			<xsl:if test="$testsuccess = 'failure'">✘</xsl:if>
			<xsl:if test="$testsuccess = 'exception'">⚠</xsl:if>
		</span>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="tabletestresults" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
		  <table class="resultstable" width="100%">
			  <tr>
        <th align="left">Description</th>
				<xsl:for-each select="results/result[1]/parameters/parameter">
					<th align="left"><xsl:value-of select="@name"/></th>
				</xsl:for-each>
				<th align="left">result</th>
			  </tr>
			  <xsl:for-each select="results/result">
			  	<xsl:variable name="row">
					<xsl:choose>
						<xsl:when test="position() mod 2 = 1">
							<xsl:text>row1test</xsl:text>
						</xsl:when>
						<xsl:otherwise>row2test</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
				<tr>
					<xsl:attribute name="class">
						<xsl:value-of select="$row" />
						<xsl:value-of select="@type" />
					</xsl:attribute>
          <td align="left">
            <xsl:value-of select="@description"/>
          </td>
					<xsl:for-each select="parameters/parameter">
						<td align="left"><xsl:value-of select="@value"/></td>
					</xsl:for-each>
          <xsl:if test="@type = 'exception'">
            <td align="left">
              <xsl:value-of select="@exceptionMessage"/>
            </td>
          </xsl:if>
          <xsl:if test="@type != 'exception'">
					  <xsl:for-each select="comparisons/comparison">
						  <td align="left">
							  <xsl:attribute name="class">
								  <xsl:value-of select="$row" />
								  <xsl:value-of select="@type" />
							  </xsl:attribute>
							  <xsl:choose>
								  <xsl:when test="@type = 'success'">
									  <xsl:value-of select="@value"/>
								  </xsl:when>
								  <xsl:when test="@type = 'failure'">
									  <xsl:value-of select="@value"/> (expected: <xsl:value-of select="@expectedValue"/>)
								  </xsl:when>
							  </xsl:choose>							
						  </td>
					  </xsl:for-each>
          </xsl:if>
				</tr>
			  </xsl:for-each>
			</table>		  
          <xsl:for-each select="results/result">
            <xsl:if test="@exceptionTrace">
              <div class="exceptiontrace">
                <xsl:call-template name="formatExceptionTrace">
                  <xsl:with-param name="text" select="@exceptionTrace" />
                </xsl:call-template>
              </div>
            </xsl:if>
          </xsl:for-each>
        </div>
        <div class="testresults">
			<xsl:value-of select="count(results/result)"/> results
		</div>
        <span class="testduration">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="results/@duration" />
          </xsl:call-template>
        </span>
      </div>
    </xsl:template>
    <xsl:template name="box">
      <xsl:param name="class" />
      <xsl:param name="color" />
      <xsl:param name="title" />
      <xsl:param name="titleRight" />
      <xsl:param name="content" />
      <div>
        <xsl:attribute name="class">
          box
          <xsl:if test="$class">
            <xsl:value-of select="$class" />
          </xsl:if>
        </xsl:attribute>
        <xsl:attribute name="style">
          border-color:
          <xsl:value-of select="$color" />
          ;
        </xsl:attribute>
        <div class="boxtitle" onClick="var div=this.parentNode.getElementsByTagName('div')[1]; if(div.style.display!='none') div.style.display='none'; else div.style.display='block';" onMouseOver="this.parentNode.style.borderStyle='dashed'; this.parentNode.style.borderColor='#000';">
          <xsl:attribute name="onMouseOut">
            <xsl:text>this.parentNode.style.borderStyle='solid'; this.parentNode.style.borderColor='</xsl:text>
            <xsl:value-of select="normalize-space($color)" />
            <xsl:text>';</xsl:text>
          </xsl:attribute>
          <xsl:attribute name="style">
            background-color:
            <xsl:value-of select="normalize-space($color)" />
            ;
          </xsl:attribute>
          <span class="boxtitleleft">
            <xsl:value-of select="$title" />
          </span>
          <xsl:if test="$titleRight">
            <span class="boxtitleright">
              <xsl:value-of select="$titleRight" />
            </span>
          </xsl:if>
        </div>
        <div class="boxcontent">
          <xsl:copy-of select="$content" />
        </div>
      </div>
    </xsl:template>
    <xsl:template name="duration">
      <xsl:param name="value" />
      <xsl:variable name="hours">
        <xsl:value-of select="floor($value div 3600000)" />
      </xsl:variable>
      <xsl:variable name="minutes">
        <xsl:value-of select="floor(($value mod 3600000) div 60000)" />
      </xsl:variable>
      <xsl:variable name="seconds">
        <xsl:value-of select="floor(($value mod 60000) div 1000)" />
      </xsl:variable>
      <xsl:variable name="msecs">
        <xsl:value-of select="round($value mod 1000)" />
      </xsl:variable>
      <xsl:if test="$hours &gt; 0">
        <xsl:value-of select="$hours" />
        h
      </xsl:if>
      <xsl:if test="$minutes &gt; 0">
        <xsl:if test="$hours &gt; 0">
          <xsl:text />
        </xsl:if>
        <xsl:value-of select="$minutes" />
        m
      </xsl:if>
      <xsl:if test="$seconds &gt; 0">
        <xsl:if test="$hours &gt; 0 or $minutes &gt; 0">
          <xsl:text />
        </xsl:if>
        <xsl:value-of select="$seconds" />
        s
      </xsl:if>
      <xsl:if test="$msecs &gt; 0">
        <xsl:choose>
          <xsl:when test="$hours &gt; 0 or $minutes &gt; 0 or $seconds &gt; 0">
            <xsl:text />
            <xsl:value-of select="$msecs" />
            ms
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="$value" />
            ms
          </xsl:otherwise>
        </xsl:choose>
      </xsl:if>
    </xsl:template>
    <xsl:template name="formatExceptionTrace">
      <xsl:param name="text" />
      <xsl:choose>
        <xsl:when test="not(contains($text, '&#xA;'))">
          <xsl:copy-of select="$text" />
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-before($text, '&#xA;')" />
          <br />
          <span class="tab" />
          <xsl:call-template name="formatExceptionTrace">
            <xsl:with-param name="text" select="substring-after($text, '&#xA;')" />
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
  </xsl:stylesheet>