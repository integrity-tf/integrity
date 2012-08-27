<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	id="xhtmltransform" version="1.0">
	<xsl:output method="html"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" />
	<xsl:variable name="suiteLinkKey" select="0" />
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
				<style type="text/css">body { color: #000; background-color: #FFF;
					font-family: Helvetica, Arial, sans-serif; font-size:12px; }
					.value { font-family: Courier, Courier New, Lucida Console, monospace; }
					.pagetitle { font-size: larger; font-weight: bold; }
					.pagesubtitle { font-weight: bold; }
					html, body { overflow: hidden; }
					a:link { color: #000; text-decoration: none; }
					a:hover { color: #000; text-decoration: underline; }
					a:visited { color: #000; text-decoration: none; }
					#header { background-image:
					url("data:image/png;base64,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");
					background-repeat: no-repeat; background-position: 4px 4px;
					padding-left: 264px; padding-top: 10px; height: 70px; line-height:
					126%; position: absolute; background-color: #FFF; z-index: 100;
					width: 100%; top: 0; }
					#viewport { top: 80px; bottom: 0px; left: 0px; right: 0px; position:
					absolute; }
					#navigation { height: 100%; padding-left: 4px; width: 256px; float: left;
					overflow: auto; }
					#innercontent { height: 100%; margin-left: 260px; padding-left: 4px;
					padding-right: 4px; overflow: auto; }
					.box { border: solid 1px; margin-top: 8px; margin-bottom: 8px; }
					.boxtitle { color: #FFF; font-weight: bold; padding: 2px 2px 2px
					2px; position: relative; left: 0px; top: 0px; border: none; }
					.boxtitleright { position: absolute; right: 2px; }
					.boxcontent { padding: 10px 10px 10px 10px; }
					table { border-spacing: 0px; margin-bottom: 2px; border-bottom: 1px
					solid #000; }
					table th { border-bottom: 1px solid #000; padding-left: 4px; }
					table td { padding-left: 4px; padding-bottom: 2px; padding-top: 2px; }
					.variabletable th { font-size: 8pt; }
					.variabletable .row1 { background-color: #D0CCFF; }
					.variabletable .row2 { background-color: #E7E6FF; }
					.sectionTitle { font-size: small; font-weight: bold; margin-bottom: 0px;
					margin-top: 8px; border-bottom: 2px solid #000; }
					.statement { border: 1px solid #FFF; position: relative; top: 0px; left: 0px;
					margin-bottom: 1px; padding-left: 40px; padding-right: 4px; }
					.statement:hover { border: 1px dashed #000; }
					.testicon { font-size: 30px; margin-left: 8px; position: absolute; left:
					0px; }
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
					.testresultvalue { font-weight: bold; }
					.testresultvaluesuccess { color: #063; }
					.testresultvaluefailure { color: #C00; }
					.testduration { font-size: 8pt; position: absolute; top: 2px; right: 4px; color:
					#555; }
					.parametertable th { font-size: 8pt; }
					.comparisontable th { font-size: 8pt; }
					.resultstable th { font-size: 8pt; }
					.comparisontable { margin-top: 10px; }
					.exceptiontrace { padding-top: 10px; padding-bottom: 5px; }
					.tab { padding-right: 20px; }
					.fixturename { font-size: 8pt; padding: 4px; }
					.comment { padding-left: 4px; padding-right: 4px; padding-top: 8px;
					padding-bottom: 4px; font-weight: bold; color: #0E4600; font-style:
					italic; }
					hr { margin-top: 8px; margin-bottom: 8px; border: 0px; height: 2px;
					background-color: #000; }
					.nav_suite { position: relative; }
					.nav_suitetitle { height: 16px; font-size: 10pt; margin-right: 2px; font-weight:
					bold; position: relative; top: -2px; left: 2px; overflow: hidden; }
					.nav_suiteresult { height: 16px; font-size: 10pt; text-align:
					right; padding-right: 2px; position: absolute; top: -2px; right:
					0px; }
					.nav_line { height: 16px; width: 16px; float: left; }
					.nav_linedown { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAZQTFRFAAAA////pdmf3QAAAAJ0Uk5T/wDltzBKAAAAFElEQVR42mJghAAGBhhjZAsABBgAeBAA4e5umaMAAAAASUVORK5CYII=");
					background-repeat: no-repeat; background-position: 0px 0px; }
					.nav_linedownright { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAZQTFRFAAAA////pdmf3QAAAAJ0Uk5T/wDltzBKAAAAGklEQVR42mJghAAGBhiDzgIwgFuArg4DCDAAcN8A06la0gYAAAAASUVORK5CYII=");
					background-repeat: no-repeat; background-position: 0px 0px; }
					.nav_lineright { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAZQTFRFAAAA////pdmf3QAAAAJ0Uk5T/wDltzBKAAAAG0lEQVR42mJghAAGBhiDzgIwgEsADugjABBgAHQgAOGUOc3nAAAAAElFTkSuQmCC");
					background-repeat: no-repeat; background-position: 0px 0px; }
					.nav_suitesuccess { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHtJREFUeNrs1jEKgDAQRcHVThBiiPc/ieDR4gpbeADLGfikSZpUb5lzxh3XFhF7ruWOXM+N3Fkbn7PXnVZv3rcAAJTVFwAACCwAAIEFACCwAAAQWAAAAgsAQGABACCwAAAEFgCAwAIAQGABAAgsAACBBQAgsAAA+M0jwACUHwWVeafwNwAAAABJRU5ErkJggg==");
					background-repeat: no-repeat; background-position: 0px 0px; }
					.nav_suitefailure { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHlJREFUeNrs1jEKgDAQRcHVThBiiMfPXeMKW3gAyxn4pEmaVG9ba0XMeUTEmWu5K9dzI3fXxufsdafVm/ctAABl9wUAAAILAEBgAQAILAAABBYAgMACABBYAAAILAAAgQUAILAAABBYAAACCwBAYAEACCwAAH7zCDAAwRoFUjYtVxsAAAAASUVORK5CYII=");
					background-repeat: no-repeat; background-position: 0px 0px; }
					.nav_suiteexception { background-image:
					url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHxJREFUeNrs1rEJgDAQhtHTThBiiPvP4UaOEU+4wgEs34OfNEmT6lvmnBH3tUXEnmu5I9dzI3fWxufsdafVm/ctAABl9QUAAAILAEBgAQAILAAABBYAgMACABBYAAAILAAAgQUAILAAABBYAAACCwBAYAEACCwAAH7zCDAAXFQFuTlYBeAAAAAASUVORK5CYII=");
					background-repeat: no-repeat; background-position: 0px 0px; }
				</style>
			</head>
			<body>
				<div id="header">
					<xsl:if test="@name">
						<div align="left" class="pagesubtitle">
							Test:
							<xsl:value-of select="@name" />
						</div>
					</xsl:if>
					<xsl:if test="count(variant) &gt; 0">
						<div align="left" class="pagesubtitle">
							Variant:
							<xsl:value-of select="variant/@name" />
							<xsl:if test="variant/@description">
								-
								<xsl:value-of select="variant/@description" />
							</xsl:if>
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
				<div id="viewport">
					<div id="navigation">
						<xsl:for-each select="suite">
							<xsl:call-template name="navigationSuite">
								<xsl:with-param name="depth" select="0" />
							</xsl:call-template>
						</xsl:for-each>
					</div>
					<div id="innercontent">
						<xsl:if test="count(variables/variable) &gt; 0">
							<xsl:call-template name="variablebox" />
						</xsl:if>
						<xsl:apply-templates select="suite" />
					</div>
				</div>
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
						<xsl:otherwise>
							row2
						</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
				<tr>
					<xsl:attribute name="class">
              <xsl:value-of select="$class" />
            </xsl:attribute>
					<td>
						<xsl:value-of select="@name" />
					</td>
					<td class="value">
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
			<xsl:with-param name="color">
				#5966FF
			</xsl:with-param>
			<xsl:with-param name="title">
				Global Variables
			</xsl:with-param>
			<xsl:with-param name="content">
				<xsl:apply-templates select="variables" />
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<xsl:template match="suite">
		<a>
			<xsl:attribute name="name">
		  <xsl:call-template name="suitePath" />
		</xsl:attribute>
		</a>
		<xsl:variable name="result">
			<xsl:choose>
				<xsl:when test="result/@exceptionCount &gt; 0">
					exception
				</xsl:when>
				<xsl:when test="result/@failureCount &gt; 0">
					failure
				</xsl:when>
				<xsl:otherwise>
					success
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:call-template name="box">
			<xsl:with-param name="color">
				<xsl:choose>
					<xsl:when test="$result = 'success'">
						#009933
					</xsl:when>
					<xsl:when test="$result = 'exception'">
						#F99500
					</xsl:when>
					<xsl:when test="$result = 'failure'">
						#CA0005
					</xsl:when>
				</xsl:choose>
			</xsl:with-param>
			<xsl:with-param name="title">
				<xsl:value-of select="@name" />
				<xsl:if test="@forkName">
					@
					<xsl:value-of select="@forkName" />
					<xsl:if test=" @forkDescription">
						-
						<xsl:value-of select="@forkDescription" />
					</xsl:if>
				</xsl:if>
			</xsl:with-param>
			<xsl:with-param name="titleRight">
				<xsl:call-template name="suiteResultSummary" />
				<xsl:if
					test="result/@successCount &gt; 0 or result/@failureCount &gt; 0 or result/@exceptionCount &gt; 0">
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
				<xsl:if
					test="count(variables/variable) &gt; 0 or count(setup/suite) &gt; 0 or count(teardown/suite) &gt; 0">
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
	<xsl:template match="comment">
		<div class="comment">
			<xsl:value-of select="@text" />
		</div>
	</xsl:template>
	<xsl:template match="divider">
		<hr />
	</xsl:template>
	<xsl:template match="call">
		<div
			onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
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
									<xsl:otherwise>
										row2
									</xsl:otherwise>
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
								<td class="value">
									<xsl:if test="@value">
										<xsl:value-of select="@value" />
									</xsl:if>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</xsl:if>
				<xsl:if test="count(result/variableUpdate) &gt; 1">
					<table class="varupdatetable" width="100%">
						<tr>
							<th width="200px" align="left">Result</th>
							<th width="200px" align="left">Variable</th>
							<th align="left">Value</th>
						</tr>
						<xsl:for-each select="result/variableUpdate">
							<xsl:variable name="class">
								<xsl:choose>
									<xsl:when test="position() mod 2 = 1">
										<xsl:text>row1</xsl:text>
									</xsl:when>
									<xsl:otherwise>
										row2
									</xsl:otherwise>
								</xsl:choose>
								<xsl:value-of select="name(../parent::*)" />
								<xsl:value-of select="../../result/@type" />
							</xsl:variable>
							<tr>
								<xsl:attribute name="class">
                    <xsl:value-of select="$class" />
                  </xsl:attribute>
								<td>
									<xsl:value-of select="@parameter" />
								</td>
								<td>
									<xsl:value-of select="@name" />
								</td>
								<td class="value">
									<xsl:value-of select="@value" />
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
			<xsl:if
				test="count(result/variableUpdate) = 1 and result/variableUpdate/@value">
				<div class="testresults">
					<xsl:if
						test="result/@type = 'success' and result/variableUpdate/@value != '(null)'">
						result:
						<span class="testResultValue testResultValueSuccess value">
							<xsl:value-of select="result/variableUpdate/@value" />
						</span>
						<xsl:if test="result/variableUpdate/@name">
							➔
							<xsl:value-of select="result/variableUpdate/@name" />
						</xsl:if>
					</xsl:if>
				</div>
			</xsl:if>
			<xsl:if
				test="count(result/variableUpdate) &gt; 1 and result/variableUpdate/@value">
				<div class="testresults">
					results:
					<xsl:for-each select="result/variableUpdate">
						<xsl:if test="position() &gt; 1">
							|
							<xsl:text />
						</xsl:if>
						<span class="value">
							<xsl:value-of select="@value" />
						</span>
						<xsl:if test="@name">
							➔
							<xsl:value-of select="@name" />
						</xsl:if>
					</xsl:for-each>
				</div>
			</xsl:if>
			<xsl:if test="result/@type = 'exception'">
				<span class="value">
					<xsl:value-of select="result/@exceptionMessage" />
				</span>
			</xsl:if>
			<span class="testduration">
				<xsl:call-template name="duration">
					<xsl:with-param name="value" select="result/@duration" />
				</xsl:call-template>
			</span>
		</div>
	</xsl:template>
	<xsl:template match="test">
		<div
			onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
			<xsl:attribute name="class">
          <xsl:text>statement row1test</xsl:text>
          <xsl:value-of select="results/result/@type" />
        </xsl:attribute>
			<span class="testicon">
				<xsl:if test="results/result/@type = 'success'">
					✔
				</xsl:if>
				<xsl:if test="results/result/@type = 'failure'">
					✘
				</xsl:if>
				<xsl:if test="results/result/@type = 'exception'">
					⚠
				</xsl:if>
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
									<xsl:otherwise>
										row2
									</xsl:otherwise>
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
								<td class="value">
									<xsl:if test="@value">
										<xsl:value-of select="@value" />
									</xsl:if>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</xsl:if>
				<xsl:if test="count(results/result/comparisons/comparison) &gt; 1">
					<table class="comparisontable" width="100%">
						<tr>
							<th width="200px" align="left">Result</th>
							<th align="left">Value</th>
						</tr>
						<xsl:for-each select="results/result/comparisons/comparison">
							<xsl:variable name="class">
								<xsl:choose>
									<xsl:when test="position() mod 2 = 1">
										<xsl:text>row1test</xsl:text>
									</xsl:when>
									<xsl:otherwise>
										row2test
									</xsl:otherwise>
								</xsl:choose>
								<xsl:value-of select="@type" />
							</xsl:variable>
							<tr>
								<xsl:attribute name="class">
                    <xsl:value-of select="$class" />
                  </xsl:attribute>
								<td>
									<xsl:value-of select="@name" />
								</td>
								<td>
									<xsl:choose>
										<xsl:when test="@type = 'success'">
											<span class="value">
												<xsl:value-of select="@value" />
											</span>
										</xsl:when>
										<xsl:when test="@type = 'failure'">
											<span class="value">
												<xsl:value-of select="@value" />
											</span>
											(expected:
											<span class="value">
												<xsl:value-of select="@expectedValue" />
											</span>
											)
										</xsl:when>
									</xsl:choose>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</xsl:if>
				<xsl:if test="results/result/@exceptionTrace">
					<div class="exceptiontrace value">
						<xsl:call-template name="formatExceptionTrace">
							<xsl:with-param name="text"
								select="results/result/@exceptionTrace" />
						</xsl:call-template>
					</div>
				</xsl:if>
			</div>
			<div class="testresults">
				<xsl:if test="results/result/@type = 'success'">
					<xsl:if test="count(results/result/comparisons/comparison) &lt; 2">
						result:
						<span class="testresultvalue testresultvaluesuccess value">
							<xsl:value-of select="results/result/comparisons/comparison/@value" />
						</span>
					</xsl:if>
					<xsl:if test="count(results/result/comparisons/comparison) &gt; 1">
						results:
						<xsl:for-each select="results/result/comparisons/comparison">
							<xsl:if test="position() &gt; 1">
								|
								<xsl:text />
							</xsl:if>
							<xsl:if test="@type = 'success'">
								<span class="testresultvalue testresultvaluesuccess value">
									<xsl:value-of select="@value" />
								</span>
							</xsl:if>
							<xsl:if test="@type = 'failure'">
								<span class="testresultvalue testresultvaluefailure">
									<span class="value">
										<xsl:value-of select="@value" />
									</span>
									<xsl:text>, but</xsl:text>
									expected:
									<span class="value">
										<xsl:value-of select="@expectedValue" />
									</span>
								</span>
							</xsl:if>
						</xsl:for-each>
					</xsl:if>
				</xsl:if>
				<xsl:if test="results/result/@type = 'failure'">
					<xsl:if test="count(results/result/comparisons/comparison) &lt; 2">
						result:
						<span class="testresultvalue testresultvaluefailure">
							<span class="value">
								<xsl:value-of select="results/result/comparisons/comparison/@value" />
							</span>
							<xsl:text>, but</xsl:text>
							expected:
							<span class="value">
								<xsl:value-of
									select="results/result/comparisons/comparison/@expectedValue" />
							</span>
						</span>
					</xsl:if>
					<xsl:if test="count(results/result/comparisons/comparison) &gt; 1">
						results:
						<xsl:for-each select="results/result/comparisons/comparison">
							<xsl:if test="position() &gt; 1">
								|
								<xsl:text />
							</xsl:if>
							<xsl:if test="@type = 'success'">
								<span class="testresultvalue testresultvaluesuccess value">
									<xsl:value-of select="@value" />
								</span>
							</xsl:if>
							<xsl:if test="@type = 'failure'">
								<span class="testresultvalue testresultvaluefailure">
									<span class="value">
										<xsl:value-of select="@value" />
									</span>
									<xsl:text>, but</xsl:text>
									expected:
									<span class="value">
										<xsl:value-of select="@expectedValue" />
									</span>
								</span>
							</xsl:if>
						</xsl:for-each>
					</xsl:if>
				</xsl:if>
				<xsl:if test="results/result/@type = 'exception'">
					<span class="value">
						<xsl:value-of select="results/result/@exceptionMessage" />
					</span>
				</xsl:if>
			</div>
			<span class="testduration">
				<xsl:call-template name="duration">
					<xsl:with-param name="value" select="results/@duration" />
				</xsl:call-template>
			</span>
		</div>
	</xsl:template>
	<xsl:template match="tabletest">
		<div
			onClick="var div=this.getElementsByTagName('div')[1]; if(div.style.display!='block') div.style.display='block'; else div.style.display='none';">
			<xsl:variable name="testsuccess">
				<xsl:choose>
					<xsl:when
						test="results/@successCount &gt; 0 and results/@failureCount = 0 and results/@exceptionCount = 0">
						success
					</xsl:when>
					<xsl:when
						test="results/@failureCount &gt; 0 and results/@exceptionCount = 0">
						failure
					</xsl:when>
					<xsl:when test="results/@exceptionCount &gt; 0">
						exception
					</xsl:when>
				</xsl:choose>
			</xsl:variable>
			<xsl:attribute name="class">
          <xsl:text>statement row1test</xsl:text>
          <xsl:value-of select="$testsuccess" />
        </xsl:attribute>
			<span class="testicon">
				<xsl:if test="$testsuccess = 'success'">
					✔
				</xsl:if>
				<xsl:if test="$testsuccess = 'failure'">
					✘
				</xsl:if>
				<xsl:if test="$testsuccess = 'exception'">
					⚠
				</xsl:if>
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
							<th align="left">
								<xsl:value-of select="@name" />
							</th>
						</xsl:for-each>
						<xsl:for-each select="results/result[1]/comparisons/comparison">
							<th align="left">
								<xsl:choose>
									<xsl:when test="@name">
										<xsl:value-of select="@name" />
									</xsl:when>
									<xsl:otherwise>
										result
									</xsl:otherwise>
								</xsl:choose>
							</th>
						</xsl:for-each>
					</tr>
					<xsl:for-each select="results/result">
						<xsl:variable name="row">
							<xsl:choose>
								<xsl:when test="position() mod 2 = 1">
									<xsl:text>row1test</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									row2test
								</xsl:otherwise>
							</xsl:choose>
						</xsl:variable>
						<tr>
							<xsl:attribute name="class">
                  <xsl:value-of select="$row" />
                  <xsl:value-of select="@type" />
                </xsl:attribute>
							<td align="left">
								<xsl:value-of select="@description" />
							</td>
							<xsl:for-each select="parameters/parameter">
								<td align="left" class="value">
									<xsl:value-of select="@value" />
								</td>
							</xsl:for-each>
							<xsl:if test="@type = 'exception'">
								<td align="left" class="value">
									<xsl:value-of select="@exceptionMessage" />
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
												<span class="value">
													<xsl:value-of select="@value" />
												</span>
											</xsl:when>
											<xsl:when test="@type = 'failure'">
												<span class="value">
													<xsl:value-of select="@value" />
												</span>
												(expected:
												<span class="value">
													<xsl:value-of select="@expectedValue" />
												</span>
												)
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
						<div class="exceptiontrace value">
							<xsl:call-template name="formatExceptionTrace">
								<xsl:with-param name="text" select="@exceptionTrace" />
							</xsl:call-template>
						</div>
					</xsl:if>
				</xsl:for-each>
			</div>
			<div class="testresults">
				<xsl:value-of select="count(results/result)" />
				results
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
			<div class="boxtitle"
				onClick="var div=this.parentNode.getElementsByTagName('div')[1]; if(div.style.display!='none') div.style.display='none'; else div.style.display='block';"
				onMouseOver="this.parentNode.style.borderStyle='dashed'; this.parentNode.style.borderColor='#000';">
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
			<xsl:value-of select="round(($value mod 1000) * 1000) div 1000" />
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
					<xsl:with-param name="text"
						select="substring-after($text, '&#xA;')" />
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="navigationLine">
		<xsl:param name="depth" />
		<xsl:param name="isLast" />
		<xsl:if test="$depth &gt; 0">
			<xsl:choose>
				<xsl:when test="$depth &gt; 1">
					<div class="nav_line nav_linedown" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:choose>
						<xsl:when test="$isLast">
							<div class="nav_line nav_lineright" />
						</xsl:when>
						<xsl:otherwise>
							<div class="nav_line nav_linedownright" />
						</xsl:otherwise>
					</xsl:choose>
				</xsl:otherwise>
			</xsl:choose>
			<xsl:call-template name="navigationLine">
				<xsl:with-param name="depth" select="$depth - 1" />
				<xsl:with-param name="isLast" select="$isLast" />
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<xsl:template name="navigationSuite">
		<xsl:param name="depth" />
		<xsl:param name="isLast" />
		<xsl:variable name="result">
			<xsl:choose>
				<xsl:when test="result/@exceptionCount &gt; 0">
					exception
				</xsl:when>
				<xsl:when test="result/@failureCount &gt; 0">
					failure
				</xsl:when>
				<xsl:otherwise>
					success
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<div>
			<xsl:attribute name="class">
		    <xsl:value-of select="concat('nav_suite nav_suite', $result)" />
	 	</xsl:attribute>
			<xsl:attribute name="style">
			<xsl:value-of
				select="concat('background-position: ', $depth * 16 - 8, 'px 0px;')" />
		</xsl:attribute>
			<xsl:call-template name="navigationLine">
				<xsl:with-param name="depth" select="$depth" />
				<xsl:with-param name="isLast" select="$isLast" />
			</xsl:call-template>
			<div class="nav_suitetitle">
				<a>
					<xsl:attribute name="href">
		  		<xsl:call-template name="suitePath">
				  <xsl:with-param name="prefix" select="'#'" />
				</xsl:call-template>
			</xsl:attribute>
					<xsl:call-template name="simpleSuiteName">
						<xsl:with-param name="fullSuiteName" select="@name" />
					</xsl:call-template>
				</a>
			</div>
			<div class="nav_suiteresult">
				<xsl:call-template name="suiteResultSummary" />
			</div>
			<xsl:for-each select="setup/suite">
				<xsl:call-template name="navigationSuite">
					<xsl:with-param name="depth" select="$depth + 1" />
					<xsl:with-param name="isLast"
						select="position() = last() and count(../../statements/suite) = 0 and count(../../teardown/suite) = 0" />
				</xsl:call-template>
			</xsl:for-each>
			<xsl:for-each select="statements/suite">
				<xsl:call-template name="navigationSuite">
					<xsl:with-param name="depth" select="$depth + 1" />
					<xsl:with-param name="isLast"
						select="position() = last() and count(../../teardown/suite) = 0" />
				</xsl:call-template>
			</xsl:for-each>
			<xsl:for-each select="teardown/suite">
				<xsl:call-template name="navigationSuite">
					<xsl:with-param name="depth" select="$depth + 1" />
					<xsl:with-param name="isLast" select="position() = last()" />
				</xsl:call-template>
			</xsl:for-each>
		</div>
	</xsl:template>
	<xsl:template name="simpleSuiteName">
		<xsl:param name="fullSuiteName" />
		<xsl:variable name="simpleSuiteName"
			select="substring-after($fullSuiteName, '&#46;')" />
		<xsl:choose>
			<xsl:when test="$simpleSuiteName">
				<xsl:call-template name="simpleSuiteName">
					<xsl:with-param name="fullSuiteName" select="$simpleSuiteName" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$fullSuiteName" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="suitePackageName">
		<xsl:param name="fullSuiteName" />
		<xsl:param name="packageName" />
		<xsl:variable name="firstPart"
			select="substring-before($fullSuiteName, '&#46;')" />
		<xsl:variable name="lastPart"
			select="substring-after($fullSuiteName, '&#46;')" />
		<xsl:choose>
			<xsl:when test="$lastPart">
				<xsl:call-template name="suitePackageName">
					<xsl:with-param name="fullSuiteName" select="$lastPart" />
					<xsl:with-param name="packageName"
						select="concat($packageName, '&#46;', $firstPart)" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$packageName" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="suitePath">
		<xsl:param name="path" />
		<xsl:param name="prefix" />
		<xsl:choose>
			<xsl:when test="name() = 'suite'">
				<xsl:variable name="currentSuiteName" select="@name" />
				<xsl:for-each select="../../.">
					<xsl:call-template name="suitePath">
						<xsl:with-param name="path"
							select="concat($currentSuiteName, '|', $path)" />
						<xsl:with-param name="prefix" select="$prefix" />
					</xsl:call-template>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat($prefix, $path)" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="suiteResultSummary">
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
	</xsl:template>
</xsl:stylesheet>