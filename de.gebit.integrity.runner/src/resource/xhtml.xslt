<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" id="xhtmltransform" version="1.0">
    <xsl:output method="html" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" />
    <xsl:variable name="suiteLinkKey" select="0" />
    <xsl:template match="integrity">
      <html>
        <head>
          <xmldata style="display: none;">
            <integrity>
              <xsl:copy-of select="attribute::*" />
              <xsl:copy-of select="variables" />
              <xsl:copy-of select="suite" />
            </integrity>
          </xmldata>
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
		font-family: Calibri, Arial, sans-serif; font-size:10pt; }
		.value { font-family: Courier, Courier New, Lucida Console, monospace; }
		.comparisondivider hr { border: 0; border-top: 1px dashed #000; height: 0px; }
		.comparisondivider em { font-weight: bold; position: relative; top: -4px; left: 4px; }
		.value .underline { text-decoration: underline; }
		.value .bold { font-weight: bold; }
		.value .italic { font-style: italic; }
		.pagetitle { font-size: 12pt; font-weight: bold; }
		.pagesubtitle { font-weight: normal; }
		.pagesubtitlebold { font-weight: bold; }
		.version { position: absolute; top: 0px; right: 267px; font-size: 8pt; display: inline; color: #999; }
		.versionnumber { font-weight: bold; }
		html, body { overflow: hidden; }
		a:link { color: #000; text-decoration: none; }
		a:hover { color: #000; text-decoration: underline; }
		a:visited { color: #000; text-decoration: none; }
		#header { background-image:
		url("data:image/png;base64,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");
		background-repeat: no-repeat; background-position: 10px 4px;
		padding-left: 264px; padding-top: 10px; height: 70px; line-height:
		126%; position: absolute; background-color: #FFF; z-index: 100;
		width: 100%; top: 0; left: 0px; border-bottom: 1px solid #000; }
		#headershadow { position: absolute; left: 0px; top: 80px; width: 100%; height: 10px; background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAKCAYAAAB10jRKAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAACdJREFUeNpiYGBgmMkEJL6BiM8g4j2IeAcn3jIDCW4QwQwi/gMEGADAHwddekPA8QAAAABJRU5ErkJggg=="); background-repeat: repeat-x; background-position: 0px 0px; }
		#viewport { top: 80px; bottom: 0px; left: 0px; right: 0px; position:
		absolute; }
		#navigation { height: 100%; padding-top: 0px; padding-left: 4px; width: 256px; float: left;
		overflow: auto; }
		#navigation-header { height: 10px; }
		#innercontent { height: 100%; padding-left: 4px;
		padding-right: 4px; overflow: auto; }
		.box { border: solid 1px; margin-top: 8px; margin-bottom: 8px; }
		.boxtitle { color: #FFF; font-weight: bold; padding: 2px 2px 2px
		2px; position: relative; left: 0px; top: 0px; border: none; }
		.boxtitle a:link { color: #FFF; text-decoration: none; font-weight: bold; }
		.boxtitle a:hover { color: #FFF; text-decoration: underline; font-weight: bold; }
		.boxtitle a:visited { color: #FFF; text-decoration: none; font-weight: bold; }
		.boxtitleright { position: absolute; right: 2px; line-height: 14px; }
		.nonbold { font-weight: normal !important; }
		.boxcontent { padding: 10px 10px 10px 10px; }
		table { border-spacing: 0px; margin-bottom: 2px; border-bottom: 1px
		solid #000; }
		table th { border-bottom: 1px solid #000; padding-left: 4px; }
		table td { padding-left: 4px; padding-bottom: 2px; padding-top: 2px; }
		.variabletable th { font-size: 8pt; }
		.variabletable .row1 { background-color: #D0CCFF; }
		.variabletable .row2 { background-color: #E7E6FF; }
		.sectionTitle { font-size: 10pt; font-weight: bold; margin-bottom: 0px;
		margin-top: 8px; border-bottom: 2px solid #000; }
		.sectionFooter { font-size: 10pt; font-weight: bold; margin-top: 0px;
		margin-bottom: 8px; border-top: 2px solid #000; }
		.statement { border: 1px solid #FFF; position: relative; top: 0px; left: 0px;
		margin-bottom: 1px; padding-left: 40px; padding-right: 4px; }
		.statement:hover { border: 1px dashed #000; }
		.testicon { width: 30px; height: 30px; position: absolute; left: 7px; top: 7px; background-repeat: no-repeat; background-position: 0px 0px; }
		.testiconsuccess { background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAeZJREFUeNpi/P//P8NAACaGAQKjFlMFNHQF/RfiYf3PyMgIxib5JZgJCZS4qIlbOz3/MwONZYBiDlGd/7NebPqPro6qlq662PxfnJ0JbikDA8f/zA0z/mNTS1WLfU3EkCxl+G+QnPMfl1qqWdo/IwQtiPX/z323hbYWb30x5b8iShCz/U9bM+0/Pj1Usbg0zwQliBX9Yv8T0kOxpeuutv4XQrKUmV36f//ddbS3OClYGcW37q1N/4nRR1n2OV33nw8lQZn8J1YvRSXXjo6lDJ+QCkHf5kjiNZPr2413e/6LI/mWT9n2Pyn6sfq4c37Wf2NLxf9Klhb/ey+txFphH+hZwvASybchrVGkBRe6S6rLrVASCzO72P/WiytQfLP93fT/Kkj5lk/Z/j+pIYalvG39L8XNgmI5ekHfNyUASZ7pf9ziKZRbjL2wZ/ivGZ4CN9xBmRcuzi5o8J+cNIJTYtaGjP8cSBaDfBY6o/f/sn3F/9mRxD07W6lrMba6FVQqWfuoIPGV/8/CUxFQVIDE+SmiBDky1ojN+E9udiRYgITPKmXQFGTDIsPG4BlrQX7pQ4zrZq5JQYlXcrMQWWU1epA71NdRZDEjKT2Jafta/79695NBVEWVIdsglpGScp5xtAtDLwAQYADjU7sCOVUG1AAAAABJRU5ErkJggg=="); }
		.testiconfailure { background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAkpJREFUeNpi/P//P8NAACaGAQJUt/hCTvh/aWGp/9YqGv+npZXhDk5QUBPCF0sy/mfbOPwv9In8j0/d0/rc//IsTCDLgJjpPx+v/P+j7ROx6iFo6ZPqjP+y3Nz/2cGGsf7vza7HaXm8DD/UUgg2Nw3GqZagxRcygv+zIRkmIWON1bBeS1UUS7l5Vf+f751CvsUg7M7LjmQopq/PZ4f950aylJlF+P/m+m680UKUxQdiXP8z4/D127bS/6rweIXEbXp4/n9CZhJlMT5fpygIowSxjWXYf2LMI9piTF9b/Z8TbIsixs2r/v/yhGnUtRiEg0W5UXyHirn/L6/s+E+sWSRZfCrZF8WHyPGaEpz7nxSzSLIYhJPQ8ioIyyvY/ifVHJKLzDQXazQRTobWcC/Sy1ZSXYqauiE42CuNZB+TpHiuszbWhMXMIv7/QNsE2sTxg8q0/0I4UzT+cpkii9Gzkr6WDlJNBMLs/+eWtFE3O20Pt0fJRpzciv/P9k76vzHQCsUxoEKFahZjK4vrk6v/Y09sxJXTRFnca6mC5ivUavFsZvB/TpSEJv3/FJ7qkCiL75TEo1R3uOKxXl8axXHWRFQUJJVSuvq+WA182ZiPktCERE3Jt/gisHLnRPEt//+tjX04DdwMrKmEhET+Kwiq/d9W3Ui+xeFo2cfdOZ7k0onksvpiZsj/9a+/wvnAkomh0tmQ9u1qMUlpBjVubjg/wM2fwb4yn5GaFrNgE5Ssm8g47/P3/7tvvmA4euMFQ42zHtV7Eowjru8EEGAA2klHim9htKoAAAAASUVORK5CYII="); }
		.testiconexception { background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAmNJREFUeNpi/P//P8NAACaGAQJDz2IPEc7/tqFp5McTKI5JxVtr3EAWAjHH/7mr5/0nxwySNXy+NPG/LhvTfzYujv9sQO0SWm70sXhypB5QF9P/+snd/3tDtKDsif9pavGDLRX/hZB8+fZ4139VoO+5hY3/33m49T/NLC6yksaIV1h8J9U00cbii/NT/3MCleu6RWNY4C7M8Z+ZTfr/geOriLackdiSK0SR7/+GZ5wMW3ZNZND4+5zhzN03QFE2BhMbA4bXe1czWOYuZbAISWU4snoWI9Wy04HOoP/MQKXBeRX/UbOT0P+t+5eDxZK0hIB83v/Ltyz8T5Wg/nZt2n9rAbb/nAJa/y9e24DT4jurC/9zA8VUrYKoY/HyPBtwlinq7PqPWYAgLAbhDn91oBjb/9750/5TZPHLA03/JYBKhBRs/j9Ayi64LIZlL3T12DDesnpa2zyGF8AEVF0fxSAv50Uw0QhZlDI2ZVgxvHtwjKF9/nnyEhe+OMPlY+Q0wcym8P/UpXX/SfZxW/1Chq8MQgwT2kJJqnQ4NTMZWyt9GBh+PWConXiYNB+fmhwNzj7uyYVYXbynI+S/gow4EKv933N4BVY1wQq8kBA5sPw/0YkLUhLhD6oDi+r+b1mNu3K4vDgTHFXYSjqsFhNT9s5NNobGMWo2Q8f1bgo462wUDrG1DaSUYgBjq8jM/4Syo4SWC36Lia1fd7b4gRsBzGyC/1dsxl9EQkIHM2Qw6lpiizxSWyzIRS6KxeX2svDgoxUOL6r+j5GPZeVEGJhp2JxlZuNkEBfigvMZR3sSw95igAADADJFvK0HWEWOAAAAAElFTkSuQmCC"); }
		.testdescription { padding-left: 4px; padding-top: 4px; padding-bottom: 4px; }
		.row1testsuccess { background-color: #BEFFBB; }
		.row2testsuccess { background-color: #E8FFE6; }
		.row1callsuccess { background-color: #DDDDDD; }
		.row2callsuccess { background-color: #EEEEEE; }
		.row1timesetsuccess { background-color: #DDDDDD; }
		.row2timesetsuccess { background-color: #EEEEEE; }
		.row1testfailure { background-color: #FF9B9B; }
		.row2testfailure { background-color: #FFC4C4; }
		.row1exception { background-color: #FFE6B7; }
		.row2exception { background-color: #FFF7E8; }
		.row1testexception { background-color: #FFE6B7; }
		.row2testexception { background-color: #FFF7E8; }
		.row1callexception { background-color: #FFE6B7; }
		.row2callexception { background-color: #FFF7E8; }
		.row1timesetexception { background-color: #FFE6B7; }
		.row2timesetexception { background-color: #FFF7E8; }
		.row1assign { background-color: #D0CCFF; }
		.postresult { font-size: 8pt; font-weight: bold; padding: 4px; position; relative; top: 0; }
		.testresults { font-size: 8pt; font-weight: bold; padding: 4px; position; relative; top: 0; }
		.testresultvalue { font-weight: bold; }
		.testresultvaluesuccess { color: #063; }
		.testresultvaluefailure { color: #C00; }
		.exceptionmessage { padding: 4px; }
		.durationandicons { font-size: 8pt; position: absolute; top: 2px; right: 4px; color: #555; }
		.timestamp { font-size: 8pt; position: absolute; top: 4px; right: 0px; color: #555; }
		.testparameters { position: relative; top: 0; min-height: 20px; }
		.tabletestresults { position: relative; top: 0; }
		.test { min-height: 46px; }
		.callexception { min-height: 46px; }
		.parametertable { margin-bottom: 10px; }
		.parametertable th { font-size: 8pt; }
		.comparisontable th { font-size: 8pt; }
		.resultstable th { font-size: 8pt; }
		.comparisontable { margin-top: 10px; }
		.exceptiontrace { padding-top: 10px; padding-bottom: 5px; }
		.extresults { padding-top: 14px; border-bottom: 1px solid #000; margin-bottom: 4px; }
		.extresultstitle { border-bottom: 1px solid #000; font-size: 8pt; font-weight: bold; }
		.extresulttitle { font-size: 8pt; font-weight: bold; margin-top: 0px; margin-left: 10px; margin-right: 4px; position: relative; top: 4px; text-decoration: underline; }
		.extresulttext { margin-top: 6px; margin-bottom: 6px; margin-left: 4px; margin-right: 4px; }
		.extresults textarea { width: 100%; }
		.extresultimage { margin-top: 6px; margin-bottom: 6px; margin-left: 4px; margin-right: 4px; }
		.timeseticon { width: 16px; height: 16px; position: absolute; left: 14px; top: 4px; background-repeat: no-repeat; background-position: 0px 0px; background-image: url("data:image/png;base64,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"); }
		.tab { padding-right: 20px; }
		.fixturename { font-size: 8pt; padding: 4px; }
		.comment { padding-left: 4px; padding-right: 4px; padding-top: 8px; }
		.comment_suitetitle { font-weight: bold; font-size: 12pt; border-bottom: 1px dashed #000; margin-bottom: 6px;  }
		.comment_title { font-weight: bold; font-size: 11pt; border-bottom: 1px dashed #000; margin-bottom: 6px;  }
		.comment a:link { color: #0E4600; text-decoration: none; font-weight: bold; }
		.comment a:hover { color: #0E4600; text-decoration: underline; font-weight: bold; }
		.comment a:visited { color: #0E4600; text-decoration: none; font-weight: bold; }
		padding-bottom: 4px; font-weight: bold; color: #0E4600; font-style:
		italic; }
		hr { margin-top: 8px; margin-bottom: 8px; border: 0px; height: 2px;
		background-color: #000; }
		.nav_suite { position: relative; background-repeat: no-repeat; background-position: 0px 0px; }
		.nav_suitetitle { height: 16px; font-size: 10pt; margin-right: 2px; font-weight:
		bold; position: relative; left: 2px; overflow: hidden; }
		.nav_suiteresult { height: 16px; font-size: 10pt; text-align: right; padding-right: 2px; padding-left: 20px; position: absolute; top: -2px; right: 0px; background-repeat: no-repeat; background-position: 0px 2px; }
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
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHtJREFUeNrs1jEKgDAQRcHVThBiiPc/ieDR4gpbeADLGfikSZpUb5lzxh3XFhF7ruWOXM+N3Fkbn7PXnVZv3rcAAJTVFwAACCwAAIEFACCwAAAQWAAAAgsAQGABACCwAAAEFgCAwAIAQGABAAgsAACBBQAgsAAA+M0jwACUHwWVeafwNwAAAABJRU5ErkJggg=="); }
		.nav_suitefailure { background-image:
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHlJREFUeNrs1jEKgDAQRcHVThBiiMfPXeMKW3gAyxn4pEmaVG9ba0XMeUTEmWu5K9dzI3fXxufsdafVm/ctAABl9wUAAAILAEBgAQAILAAABBYAgMACABBYAAAILAAAgQUAILAAABBYAAACCwBAYAEACCwAAH7zCDAAwRoFUjYtVxsAAAAASUVORK5CYII="); }
		.nav_suiteexception { background-image:
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAAPCAYAAAA4crG6AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHxJREFUeNrs1rEJgDAQhtHTThBiiPvP4UaOEU+4wgEs34OfNEmT6lvmnBH3tUXEnmu5I9dzI3fWxufsdafVm/ctAABl9QUAAAILAEBgAQAILAAABBYAgMACABBYAAAILAAAgQUAILAAABBYAAACCwBAYAEACCwAAH7zCDAAXFQFuTlYBeAAAAAASUVORK5CYII="); }
		#progressbar { margin-top: 6px; border: 1px solid #000; }
		.testicons { margin-left: 6px; float: right; }
		.testicons a { width: 10px; display: block; float: right; height: 12px; }
		.suiteicons { margin-left: 6px; float: right; }
		.suiteicons a { width: 10px; display: block; float: right; height: 12px; }
		.scriptlink { padding-right: 4px; background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAKFJREFUeNpskDEOhSAQRBdj5QHsgAbssQTuokfzRBaUxMZwkP1ZEsyKf5NJyOQxm1mBiMAnxvg22hDYZK1F5xxyjxRCwIF/yjmLaZpgWZZP6qi1fplSSvDefzbXxPu+BYkgYwwcxyH2fUeePPASHLquC+Z5hnVdKzw2kKCUEjSolFI3Uep5ngKUUk/LbduQGtKb+/WEvdHU+3V13/zf/AQYAPpsgATFn91/AAAAAElFTkSuQmCC") no-repeat right 1px; }
		.suitescriptlink { padding-right: 4px; background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAGxJREFUeNqEUFsKwCAMq1Pww/sfVbBQ7cyg4GtbQEpCmhQdLRARpT/UWhXvtHyNgvfeqSqdzKG1NomdUyllrxuNqMg5PxzTkqdqEGamlJKDKcZI0xmWaAmYWDJ9M5rZvme9fRde9PBlHnELMABfRYFq6Zhw8gAAAABJRU5ErkJggg==") no-repeat right 2px; }
		.console { border: 1px solid #000; margin-bottom: 5px; margin-top: 4px; background-color: #FFF; display: none; }
		.console ol { padding-left: 0px; margin-top: 0px; margin-bottom: 0px; counter-reset: item; list-style-type: none; font-family: Courier, Courier New, Lucida Console, monospace; }
		.console li { padding-left: 4px; padding-right: 4px; }
		.console li:before { content: counter(item) "  "; counter-increment: item; width: 46px; text-align: right; display: block; float: left; padding-right: 4px; margin-right: 4px; border-right: 1px solid #DDD; }
		.consoleheader { font-weight: bold; padding-left: 3px; padding-top: 0px; padding-bottom: 2px; color: #FFF; background-color: #000; }
		.err { color: #FF3030; font-weight: bold; }
		.row0c { background-color: #F6F6F6; }
		.row1c { background-color: #FFFFFF; }
		.masterconsole { font-style: italic; }
		.abortmessageintro { color: #FF3030; }
		.abortmessage { color: #FF3030; font-weight: bold; }
		#abortmessagebig { color: #FF3030; font-weight: bold; font-size: 14pt; text-align: center; }</style>
          <script type="text/javascript">var lastSelection;
 
 function boxOrCellMouseDown() {
  if(clicks==0) {
  	lastSelection = window.getSelection().toString();
  }
}
 
 function jumpToAnchor() {
	var hash = self.document.location.hash;
	if(hash) {
		window.location.hash = hash;
	}
}
 
 function boxMouseUp(aBox, e) {
  doMouseUpValidation(e, function() {
  	var div=aBox.parentNode.getElementsByTagName('div')[1]; 
  	if(div.style.display!='none') 
	    div.style.display='none';
	  else
	    div.style.display='block';
	});
}

function cellMouseUp(aCell, e) {
	doMouseUpValidation(e, function() {
		for(var i=1; i &lt; aCell.getElementsByTagName('div').length; i++) {
	  	var div=aCell.getElementsByTagName('div')[i];
	  	if(div.className.includes('expandable')) {
	  		if(div.style.display!='block')
	    		div.style.display='block';
      	else
	    		div.style.display='none';
	    }
	  }
	});
}

clicks = 0;

function doMouseUpValidation(event, aFunctionToCall) {
	if(event.which) rightClick = (event.which == 3);
	else if (event.button) rightClick = (event.button == 2);
	if(rightClick) {
		return;
	}			
	clicks++;
  if(clicks==1) {			  
  	setTimeout(function() {
  		clicks = 0;
  		if(window.getSelection().toString() != lastSelection) return;
  		aFunctionToCall();
	  }, 150);
	}
}

function swallowMouseUp(e) {
	if (!e) var e = window.event;
	e.stopPropagation();
}

function resizeProgressBar() {
	var bar=document.getElementById('progressbar');
	var container=bar.parentNode;
	var width = (container.clientWidth - 264) - 264 - 10;
	if (bar.width != width &amp;&amp; width &gt; 0) {
	  bar.width=width;
	  redrawProgressBar();
	}
}

function redrawProgressBar() {
	var totalCount = countTestsAndCalls();
	var bar=document.getElementById('progressbar');
	if (bar.getContext &amp;&amp; totalCount &gt; 0){
		var context = bar.getContext('2d');
		var root = getChildByName(document.getElementsByTagName('integrity')[0], 'SUITE');
		var pixelsPerNode = bar.width / totalCount;
		var height = bar.clientHeight;
		pixelLevel = 0;
		recursiveRedrawProgressBar(context, root, 0, pixelsPerNode, height);			
	}
}

var pixelLevel = 0;
var pixelLink = -1;
var clickMap = {};

function recursiveRedrawProgressBar(context, node, nodePos, pixelsPerNode, height) {
	if (node.nodeName == 'CALL') {
	    if (pixelLink == -1) {
			pixelLink = node.getAttribute('id');
		}
		var result = getChildByName(node, 'RESULT');
		if (result.getAttribute('type') == 'exception') {
			pixelLevel = 2;
		}
	} else if (node.nodeName == 'TEST' || node.nodeName == 'TABLETEST') {
		if (pixelLink == -1) {
			pixelLink = node.getAttribute('id');
		}
		var results = getChildByName(node, 'RESULTS');
		if (results.getAttribute('exceptionCount') != 0) {
			pixelLevel = 2;
			pixelLink = node.getAttribute('id');
		} else if (results.getAttribute('failureCount') != 0) {
			if (pixelLevel == 0) {
				pixelLevel = 1;
				pixelLink = node.getAttribute('id');
			}
		}
	} else if (node.nodeName == 'TIMESET') {
		if (pixelLink == -1) {
			pixelLink = node.getAttribute('id');
		}
		if (node.hasAttribute('exceptionMessage')) {
			pixelLevel = 2;
		}
	} else {
		if (node.childNodes) {
			for (var i = 0; i &lt; node.childNodes.length; i++) {
				var child = node.childNodes[i];
				var newNodePos = recursiveRedrawProgressBar(context, child, nodePos, pixelsPerNode, height);
				if(newNodePos == -1) {
					pixelLevel = 0;
					pixelLink = -1;
					nodePos++;
				} else {
					nodePos = newNodePos;
				}
			}
		}
		return nodePos;
	}
	
	var pixelPos = Math.floor(nodePos * pixelsPerNode);
	nodePos++;
	var newPixelPos = Math.floor(nodePos * pixelsPerNode);
	if (newPixelPos != pixelPos) {
		switch (pixelLevel) {
		case 1:
			context.fillStyle = "rgb(202,0,5)";
			break;
		case 2:
			context.fillStyle = "rgb(249,149,0)";
			break;
		default:
			context.fillStyle = "rgb(0,153,51)";
		}
		var width = newPixelPos - pixelPos;
		context.fillRect(pixelPos, 0, width, height);
		for(var i = pixelPos; i &lt; newPixelPos; i++) {
			clickMap[i] = pixelLink;
		}
		
		return -1;
	} else {
		return nodePos;
	}
}

function handleProgressBarClick(event) {
	var pos_x = event.pageX - document.getElementById("progressbar").offsetLeft;
	if(clickMap[pos_x]) {
		window.location.hash = '#i' + clickMap[pos_x];
	}
}

function countTestsAndCalls() {
	var root=document.getElementsByTagName('integrity')[0];
	return root.getElementsByTagName('test').length + root.getElementsByTagName('call').length + root.getElementsByTagName('tabletest').length + root.getElementsByTagName('timeSet').length;
}

function getChildByName(node, childName) {
	if (node.childNodes) {
		for (var i = 0; i &lt; node.childNodes.length; i++) {
			var child = node.childNodes[i];
			if (child.nodeName == childName) {
				return child;
			}
		}
	}
	return null;
}</script>
        </head>
        <body onLoad="resizeProgressBar()" onResize="resizeProgressBar()">
          <div id="header">
            <xsl:if test="@name">
              <div align="left" class="pagesubtitle">
                Test:
                <span class="pagesubtitlebold">
                  <xsl:value-of select="@name" />
                </span>
                <xsl:if test="count(variant) &gt; 0">
                  in variant
                  <span class="pagesubtitlebold">
                    <xsl:value-of select="variant/@name" />
                    <xsl:if test="variant/@description">
                      <xsl:value-of select="concat(' - ', variant/@description)" />
                    </xsl:if>
                  </span>
                </xsl:if>
              </div>
            </xsl:if>
            <div align="left" class="pagesubtitle">
              Started
              <span class="pagesubtitlebold">
                <xsl:value-of select="@timestamp" />
              </span>
              and took
              <span class="pagesubtitlebold">
                <xsl:call-template name="duration">
                  <xsl:with-param name="value" select="@duration" />
                </xsl:call-template>
              </span>
              <xsl:choose>
                <xsl:when test="@abortMessage">
                  <span class="abortmessageintro">until aborted:</span>
                  <span class="abortmessage">
                    <xsl:value-of select="@abortMessage" />
                  </span>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:value-of select="concat(' ', 'to complete')" />
                </xsl:otherwise>
              </xsl:choose>
            </div>
            <xsl:if test="@version">
              <div align="right" class="version">
                <a href="http://www.integrity-tf.org" target="_blank">
                  Integrity Test Runner Version
                  <span class="versionnumber">
                    <xsl:value-of select="@version" />
                  </span>
                </a>
              </div>
            </xsl:if>
            <canvas id="progressbar" width="0" height="16" onClick="handleProgressBarClick(event)" onMouseOver="this.style.cursor='pointer';" onMouseOut="this.style.cursor='default';" />
            <div id="headershadow" />
          </div>
          <div id="viewport">
            <div id="navigation">
              <div id="navigation-header" />
              <xsl:for-each select="suite">
                <xsl:call-template name="navigationSuite">
                  <xsl:with-param name="depth" select="0" />
                  <xsl:with-param name="path" select="''" />
                  <xsl:with-param name="siblingCount" select="0" />
                </xsl:call-template>
              </xsl:for-each>
            </div>
            <div id="innercontent">
              <xsl:if test="count(variables/variable) &gt; 0">
                <xsl:call-template name="variablebox" />
              </xsl:if>
              <xsl:apply-templates select="suite" />
              <xsl:if test="@abortMessage">
                <div id="abortmessagebig">
                  <xsl:value-of select="concat('Execution was aborted prematurely: ', @abortMessage)" />
                </div>
              </xsl:if>
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
            <td class="value">
              <xsl:if test="@value">
                <xsl:call-template name="processFormattedString">
                  <xsl:with-param name="text" select="@value" />
                </xsl:call-template>
              </xsl:if>
            </td>
          </tr>
        </xsl:for-each>
      </table>
    </xsl:template>
    <xsl:template match="returns">
      <table class="variabletable" width="100%">
        <tr>
          <th width="200px" align="left">Source Variable</th>
          <th width="200px" align="left">Target Variable</th>
          <th align="left">Value</th>
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
              <xsl:value-of select="@target" />
            </td>
            <td class="value">
              <xsl:if test="@value">
                <xsl:call-template name="processFormattedString">
                  <xsl:with-param name="text" select="@value" />
                </xsl:call-template>
              </xsl:if>
            </td>
          </tr>
        </xsl:for-each>
      </table>
    </xsl:template>
    <xsl:template name="variablebox">
      <xsl:call-template name="box">
        <xsl:with-param name="color">#5966FF</xsl:with-param>
        <xsl:with-param name="title">Global Variables/Constants</xsl:with-param>
        <xsl:with-param name="content">
          <xsl:apply-templates select="variables" />
        </xsl:with-param>
      </xsl:call-template>
    </xsl:template>
    <xsl:template match="suite">
      <xsl:variable name="permalink">
        <xsl:call-template name="suitePath" />
      </xsl:variable>
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="$permalink" />
        </xsl:attribute>
      </a>
      <xsl:variable name="result">
        <xsl:choose>
          <xsl:when test="result/@exceptionCount &gt; 0">exception</xsl:when>
          <xsl:when test="result/@failureCount &gt; 0">failure</xsl:when>
          <xsl:otherwise>success</xsl:otherwise>
        </xsl:choose>
      </xsl:variable>
      <xsl:choose>
        <xsl:when test="@display = 'inline'">
          <xsl:if test="@forkName and not(../../@forkName)">
            <div class="sectionTitle">
              Switching to
              <xsl:value-of select="@forkName" />
              <xsl:if test=" @forkDescription">
                -
                <xsl:value-of select="@forkDescription" />
              </xsl:if>
            </div>
          </xsl:if>
          <xsl:if test="count(setup/suite) &gt; 0">
            <xsl:apply-templates select="setup/suite" />
          </xsl:if>
          <xsl:apply-templates select="statements/*" />
          <xsl:if test="count(teardown/suite) &gt; 0">
            <xsl:apply-templates select="teardown/suite" />
          </xsl:if>
          <xsl:if test="@forkName and not(../../@forkName)">
            <div class="sectionFooter">
              Returning from
              <xsl:value-of select="@forkName" />
              <xsl:if test=" @forkDescription">
                -
                <xsl:value-of select="@forkDescription" />
              </xsl:if>
            </div>
          </xsl:if>
        </xsl:when>
        <xsl:otherwise>
          <xsl:call-template name="box">
            <xsl:with-param name="color">
              <xsl:choose>
                <xsl:when test="$result = 'success'">#009933</xsl:when>
                <xsl:when test="$result = 'exception'">#F99500</xsl:when>
                <xsl:when test="$result = 'failure'">#CA0005</xsl:when>
              </xsl:choose>
            </xsl:with-param>
            <xsl:with-param name="title">
              <a>
                <xsl:attribute name="href">
                  <xsl:value-of select="concat('#', $permalink)" />
                </xsl:attribute>
                <xsl:choose>
                  <xsl:when test="@title">
                    <xsl:value-of select="@title" />
                    <span class="nonbold">
                      <xsl:value-of select="concat(' (',@name,')')" />
                    </span>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:value-of select="@name" />
                  </xsl:otherwise>
                </xsl:choose>
              </a>
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
              <xsl:text />
              at
              <xsl:text />
              <xsl:value-of select="@timestamp" />
              <xsl:text />
              in
              <xsl:text />
              <xsl:call-template name="duration">
                <xsl:with-param name="value" select="result/@duration" />
              </xsl:call-template>
              <span class="suiteicons">
                <xsl:if test="ancestor::suite[1]/@name">
                  <xsl:call-template name="scriptlink">
                    <xsl:with-param name="line" select="@line" />
                    <xsl:with-param name="suite" select="ancestor::suite[1]/@name" />
                    <xsl:with-param name="class" select="'suitescriptlink'" />
                  </xsl:call-template>
                </xsl:if>
              </span>
            </xsl:with-param>
            <xsl:with-param name="content">
              <xsl:if test="count(variables/variable) &gt; 0">
                <div class="sectionTitle">Variables/Constants</div>
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
              <xsl:if test="count(returns/variable) &gt; 0">
                <div class="sectionTitle">Returned Values</div>
                <xsl:apply-templates select="returns" />
              </xsl:if>
            </xsl:with-param>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
    <xsl:template match="comment">
      <div>
        <xsl:attribute name="class">
          comment
          <xsl:if test="@type = 'suitetitle'">comment_suitetitle</xsl:if>
          <xsl:if test="@type = 'title'">comment_title</xsl:if>
        </xsl:attribute>
        <xsl:copy-of select="child::node()" />
      </div>
    </xsl:template>
    <xsl:template match="divider">
      <hr />
    </xsl:template>
    <xsl:template match="call">
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <div onMouseDown="boxOrCellMouseDown()" onMouseUp="cellMouseUp(this, event)">
        <xsl:attribute name="class">
          <xsl:text>statement row1call</xsl:text>
          <xsl:value-of select="result/@type" />
        </xsl:attribute>
        <xsl:if test="result/@type = 'exception'">
          <div class="testicon testiconexception" />
        </xsl:if>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="testparameters expandable" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
          <div class="timestamp">
            <xsl:value-of select="@timestamp" />
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
                  <td class="value">
                    <xsl:if test="@value">
                      <xsl:call-template name="processFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
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
                    <xsl:value-of select="@parameter" />
                  </td>
                  <td>
                    <xsl:value-of select="@name" />
                  </td>
                  <td class="value">
                    <xsl:if test="@value">
                      <xsl:call-template name="processFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
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
          <xsl:if test="count(extResults/*) &gt; 0">
            <xsl:apply-templates select="extResults" />
          </xsl:if>
        </div>
        <xsl:if test="count(result/variableUpdate) = 1 and result/variableUpdate/@value">
          <div class="testresults">
            <xsl:if test="result/@type = 'success' and result/variableUpdate/@value != '(null)'">
              result:
              <span class="testResultValue testResultValueSuccess value">
                <xsl:call-template name="stripFormattedString">
                  <xsl:with-param name="text" select="result/variableUpdate/@value" />
                </xsl:call-template>
              </span>
              <xsl:if test="result/variableUpdate/@name">
                ➔
                <xsl:value-of select="result/variableUpdate/@name" />
              </xsl:if>
            </xsl:if>
          </div>
        </xsl:if>
        <xsl:if test="count(result/variableUpdate) &gt; 1 and result/variableUpdate/@value">
          <div class="testresults">
            results:
            <xsl:for-each select="result/variableUpdate">
              <xsl:if test="position() &gt; 1">
                |
                <xsl:text />
              </xsl:if>
              <span class="value">
                <xsl:call-template name="stripFormattedString">
                  <xsl:with-param name="text" select="result/variableUpdate/@value" />
                </xsl:call-template>
              </span>
              <xsl:if test="@name">
                ➔
                <xsl:value-of select="@name" />
              </xsl:if>
            </xsl:for-each>
          </div>
        </xsl:if>
        <xsl:if test="result/@type = 'exception'">
          <div class="value exceptionmessage">
            <xsl:value-of select="result/@exceptionMessage" />
          </div>
        </xsl:if>
        <xsl:apply-templates select="result/console" />
        <span class="durationandicons">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="result/@duration" />
          </xsl:call-template>
          <span class="testicons">
            <xsl:call-template name="scriptlink">
              <xsl:with-param name="line" select="@line" />
              <xsl:with-param name="suite" select="ancestor::suite[1]/@name" />
              <xsl:with-param name="class" select="'scriptlink'" />
            </xsl:call-template>
          </span>
        </span>
      </div>
    </xsl:template>
    <xsl:template match="timeSet">
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <div onMouseDown="boxOrCellMouseDown()" onMouseUp="cellMouseUp(this, event)">
        <xsl:attribute name="class">
          <xsl:text>statement row1timeset</xsl:text>
          <xsl:choose>
	          <xsl:when test="@exceptionMessage">
	          	<xsl:text>exception</xsl:text>
	          </xsl:when>
	          <xsl:otherwise>
	          	<xsl:text>success</xsl:text>
	          </xsl:otherwise>
          </xsl:choose>
        </xsl:attribute>
        <xsl:choose>
	        <xsl:when test="@exceptionMessage">
	          <div class="testicon testiconexception" />
	        </xsl:when>
	        <xsl:otherwise>
	          <div class="timeseticon" />
	        </xsl:otherwise>
        </xsl:choose>
        <div class="testdescription">
          <xsl:value-of select="@text" />
        </div>
        <div class="testparameters expandable" style="display: none;">
          <div class="timestamp">
            <xsl:value-of select="@timestamp" />
          </div>
          <xsl:if test="@exceptionTrace">
            <div class="exceptiontrace">
              <xsl:call-template name="formatExceptionTrace">
                <xsl:with-param name="text" select="@exceptionTrace" />
              </xsl:call-template>
            </div>
          </xsl:if>
          <xsl:if test="count(extResults/*) &gt; 0">
            <xsl:apply-templates select="extResults" />
          </xsl:if>
        </div>        
        <xsl:if test="@exceptionTrace">
          <div class="value exceptionmessage">
            <xsl:value-of select="@exceptionMessage" />
          </div>
        </xsl:if>        
        <span class="durationandicons">
          <span class="testicons">
            <xsl:call-template name="scriptlink">
              <xsl:with-param name="line" select="@line" />
              <xsl:with-param name="suite" select="ancestor::suite[1]/@name" />
              <xsl:with-param name="class" select="'scriptlink'" />
            </xsl:call-template>
          </span>
        </span>
      </div>
    </xsl:template>
    <xsl:template match="variableAssign">
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <div onMouseDown="boxOrCellMouseDown()" onMouseUp="cellMouseUp(this, event)" class="statement row1assign">
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="testparameters expandable" style="display: none;">
          <div class="timestamp">
            <xsl:value-of select="@timestamp" />
          </div>
          <table class="varupdatetable" width="100%">
            <tr>
              <th width="200px" align="left">Variable</th>
              <th align="left">Value</th>
            </tr>
            <tr class="row1">
              <td>
                <xsl:value-of select="@name" />
              </td>
              <td class="value">
                <xsl:if test="@value">
                  <xsl:call-template name="processFormattedString">
                    <xsl:with-param name="text" select="@value" />
                  </xsl:call-template>
                </xsl:if>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </xsl:template>
    <xsl:template match="extResults">
      <div class="extresults">
        <div class="extresultstitle">Extended Result Details</div>
        <xsl:for-each select="*">
          <xsl:if test="@title">
            <div class="extresulttitle">
              <xsl:value-of select="@title" />
            </div>
          </xsl:if>
          <xsl:if test="name() = 'extResultText'">
            <div class="extresulttext">
              <textarea onMouseUp="swallowMouseUp(event)">
                <xsl:value-of select="text()" />
              </textarea>
            </div>
          </xsl:if>
          <xsl:if test="name() = 'extResultImage'">
            <div class="extresultimage">
              <div>
                <xsl:attribute name="style">
                  <xsl:value-of select="concat('width:', @width, 'px; height:', @height, 'px; background-image:url(', &quot;'&quot;, 'data:', @type, ';base64,', text(), &quot;'&quot;, ');')" />
                </xsl:attribute>
              </div>
            </div>
          </xsl:if>
          <xsl:if test="name() = 'extResultHTML'">
            <div class="extresulthtml">
              <xsl:value-of select="text()" disable-output-escaping="yes" />
            </div>
          </xsl:if>
        </xsl:for-each>
      </div>
    </xsl:template>
    <xsl:template match="console">
      <xsl:variable name="headerending">
        <xsl:choose>
          <xsl:when test="@lines = 1">
            <xsl:text>line</xsl:text>
          </xsl:when>
          <xsl:otherwise>lines</xsl:otherwise>
        </xsl:choose>
      </xsl:variable>
      <div class="console expandable">
        <div class="consoleheader">
          <xsl:value-of select="concat('Console output: ', @lines, ' ', $headerending)" />
          <xsl:if test="@truncated &gt; 0">
            <xsl:value-of select="concat(' (', @truncated, ' additional lines were truncated)')" />
          </xsl:if>
        </div>
        <ol>
          <xsl:apply-templates select="out | err" />
          <xsl:if test="@truncated &gt; 0">
            <li class="err row1c">
              <xsl:value-of select="concat('LINE COUNT LIMIT WAS HIT - ', @truncated, ' ADDITIONAL LINES WERE TRUNCATED FROM CAPTURE')" />
            </li>
          </xsl:if>
        </ol>
      </div>
    </xsl:template>
    <xsl:template match="out | err">
      <li>
        <xsl:variable name="source">
          <xsl:if test="ancestor-or-self::suite[1]/@forkName and not(@source = 'fork')">
            <xsl:value-of select="concat(' ', 'masterconsole')" />
          </xsl:if>
        </xsl:variable>
        <xsl:attribute name="class">
          <xsl:value-of select="concat(name(), ' ', 'row', position() mod 2, 'c', $source)" />
        </xsl:attribute>
        <xsl:call-template name="fixSpaces">
          <xsl:with-param name="text" select="@text" />
        </xsl:call-template>
      </li>
    </xsl:template>
    <xsl:template match="test">
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <div onMouseDown="boxOrCellMouseDown()" onMouseUp="cellMouseUp(this, event)">
        <xsl:attribute name="class">
          <xsl:text>statement test row1test</xsl:text>
          <xsl:value-of select="results/result/@type" />
        </xsl:attribute>
        <div>
          <xsl:attribute name="class">
            <xsl:text>testicon testicon</xsl:text>
            <xsl:value-of select="results/result/@type" />
          </xsl:attribute>
        </div>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="testparameters expandable" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
          <div class="timestamp">
            <xsl:value-of select="@timestamp" />
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
                  <td class="value">
                    <xsl:if test="@value">
                      <xsl:call-template name="processFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
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
                    <xsl:otherwise>row2test</xsl:otherwise>
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
                    <xsl:call-template name="formattedComparisonResult" />
                  </td>
                </tr>
              </xsl:for-each>
            </table>
          </xsl:if>
          <xsl:if test="count(results/result/comparisons/comparison) = 1">
            <table class="comparisontable" width="100%">
              <tr>
                <th width="100%" align="left">Result</th>
              </tr>
              <xsl:for-each select="results/result/comparisons/comparison">
                <xsl:variable name="class">
                  <xsl:choose>
                    <xsl:when test="position() mod 2 = 1">
                      <xsl:text>row1test</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>row2test</xsl:otherwise>
                  </xsl:choose>
                  <xsl:value-of select="@type" />
                </xsl:variable>
                <tr>
                  <xsl:attribute name="class">
                    <xsl:value-of select="$class" />
                  </xsl:attribute>
                  <td>
                    <xsl:call-template name="formattedComparisonResult" />
                  </td>
                </tr>
              </xsl:for-each>
            </table>
          </xsl:if>
          <xsl:if test="results/result/@exceptionTrace">
            <div class="exceptiontrace value">
              <xsl:call-template name="formatExceptionTrace">
                <xsl:with-param name="text" select="results/result/@exceptionTrace" />
              </xsl:call-template>
            </div>
          </xsl:if>
          <xsl:if test="count(extResults/*) &gt; 0">
            <xsl:apply-templates select="extResults" />
          </xsl:if>
        </div>
        <div class="testresults">
          <xsl:if test="results/result/@type = 'success'">
            <xsl:if test="count(results/result/comparisons/comparison) &lt; 2">
              result:
              <span class="testresultvalue testresultvaluesuccess value">
                <xsl:call-template name="stripFormattedString">
                  <xsl:with-param name="text" select="results/result/comparisons/comparison/@value" />
                </xsl:call-template>
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
                    <xsl:call-template name="stripFormattedString">
                      <xsl:with-param name="text" select="@value" />
                    </xsl:call-template>
                  </span>
                </xsl:if>
                <xsl:if test="@type = 'failure'">
                  <span class="testresultvalue testresultvaluefailure">
                    <span class="value">
                      <xsl:call-template name="stripFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
                    </span>
                    <xsl:text>, but</xsl:text>
                    expected:
                    <span class="value">
                      <xsl:call-template name="stripFormattedString">
                        <xsl:with-param name="text" select="@expectedValue" />
                      </xsl:call-template>
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
                  <xsl:call-template name="stripFormattedString">
                    <xsl:with-param name="text" select="results/result/comparisons/comparison/@value" />
                  </xsl:call-template>
                </span>
                <xsl:text>, but</xsl:text>
                expected:
                <span class="value">
                  <xsl:call-template name="stripFormattedString">
                    <xsl:with-param name="text" select="results/result/comparisons/comparison/@expectedValue" />
                  </xsl:call-template>
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
                    <xsl:call-template name="stripFormattedString">
                      <xsl:with-param name="text" select="@value" />
                    </xsl:call-template>
                  </span>
                </xsl:if>
                <xsl:if test="@type = 'failure'">
                  <span class="testresultvalue testresultvaluefailure">
                    <span class="value">
                      <xsl:call-template name="stripFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
                    </span>
                    <xsl:text>, but</xsl:text>
                    expected:
                    <span class="value">
                      <xsl:call-template name="stripFormattedString">
                        <xsl:with-param name="text" select="@expectedValue" />
                      </xsl:call-template>
                    </span>
                  </span>
                </xsl:if>
              </xsl:for-each>
            </xsl:if>
          </xsl:if>
          <xsl:if test="results/result/@type = 'exception'">
            <div class="value exceptionmessage">
              <xsl:value-of select="results/result/@exceptionMessage" />
            </div>
          </xsl:if>
        </div>
        <xsl:apply-templates select="results/console" />
        <span class="durationandicons">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="results/@duration" />
          </xsl:call-template>
          <span class="testicons">
            <xsl:call-template name="scriptlink">
              <xsl:with-param name="line" select="@line" />
              <xsl:with-param name="suite" select="ancestor::suite[1]/@name" />
              <xsl:with-param name="class" select="'scriptlink'" />
            </xsl:call-template>
          </span>
        </span>
      </div>
    </xsl:template>
    <xsl:template match="tabletest">
      <a>
        <xsl:attribute name="name">
          <xsl:value-of select="concat('i', @id)" />
        </xsl:attribute>
      </a>
      <div onMouseDown="boxOrCellMouseDown()" onMouseUp="cellMouseUp(this, event)">
        <xsl:variable name="tablesuccess">
          <xsl:choose>
            <xsl:when test="results/@successCount &gt; 0 and results/@failureCount = 0 and results/@exceptionCount = 0">success</xsl:when>
            <xsl:when test="results/@failureCount &gt; 0 and results/@exceptionCount = 0">failure</xsl:when>
            <xsl:when test="results/@exceptionCount &gt; 0">exception</xsl:when>
          </xsl:choose>
        </xsl:variable>
        <xsl:variable name="testsuccess">
          <xsl:choose>
            <xsl:when test="$tablesuccess = 'success' and not(postResult/@type = 'exception' or postResult/@type = 'failure')">success</xsl:when>
            <xsl:when test="postResult/@type = 'failure' and not($tablesuccess = 'exception')">failure</xsl:when>
            <xsl:when test="$tablesuccess = 'exception' or postResult/@type = 'exception'">exception</xsl:when>
          </xsl:choose>
        </xsl:variable>
        <xsl:attribute name="class">
          <xsl:text>statement test row1test</xsl:text>
          <xsl:value-of select="$testsuccess" />
        </xsl:attribute>
        <div>
          <xsl:attribute name="class">
            <xsl:text>testicon testicon</xsl:text>
            <xsl:value-of select="$testsuccess" />
          </xsl:attribute>
        </div>
        <div class="testdescription">
          <xsl:value-of select="@description" />
        </div>
        <div class="tabletestresults expandable" style="display: none;">
          <div class="fixturename">
            <xsl:value-of select="@fixture" />
          </div>
          <div class="timestamp">
            <xsl:value-of select="@timestamp" />
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
                  <td class="value">
                    <xsl:if test="@value">
                      <xsl:call-template name="processFormattedString">
                        <xsl:with-param name="text" select="@value" />
                      </xsl:call-template>
                    </xsl:if>
                  </td>
                </tr>
              </xsl:for-each>
            </table>
          </xsl:if>
          <table class="resultstable" width="100%">
            <tr>
              <th align="left">Result Description</th>
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
                    <xsl:otherwise>result</xsl:otherwise>
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
                  <xsl:otherwise>row2test</xsl:otherwise>
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
                    <xsl:call-template name="stripFormattedString">
                      <xsl:with-param name="text" select="@value" />
                    </xsl:call-template>
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
                            <xsl:call-template name="stripFormattedString">
                              <xsl:with-param name="text" select="@value" />
                            </xsl:call-template>
                          </span>
                        </xsl:when>
                        <xsl:when test="@type = 'failure'">
                          <span class="value">
                            <xsl:call-template name="stripFormattedString">
                              <xsl:with-param name="text" select="@value" />
                            </xsl:call-template>
                          </span>
                          (expected:
                          <span class="value">
                            <xsl:call-template name="stripFormattedString">
                              <xsl:with-param name="text" select="@expectedValue" />
                            </xsl:call-template>
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
          <xsl:if test="count(extResults/*) &gt; 0">
            <xsl:apply-templates select="extResults" />
          </xsl:if>
        </div>
        <xsl:apply-templates select="postResult" />
        <div class="testresults">
          <xsl:value-of select="count(results/result)" />
          results
        </div>
        <xsl:apply-templates select="results/console" />
        <span class="durationandicons">
          <xsl:call-template name="duration">
            <xsl:with-param name="value" select="results/@duration" />
          </xsl:call-template>
          <span class="testicons">
            <xsl:call-template name="scriptlink">
              <xsl:with-param name="line" select="@line" />
              <xsl:with-param name="suite" select="ancestor::suite[1]/@name" />
              <xsl:with-param name="class" select="'scriptlink'" />
            </xsl:call-template>
          </span>
        </span>
      </div>
    </xsl:template>
    <xsl:template match="postResult">
     	<xsl:choose>
	    	<xsl:when test="@type = 'failure'">
	    		<div class="postresult testresultvaluefailure">
		          Finalization test has failed: 
		          <xsl:value-of select="@value" />
		        </div>
	    	</xsl:when>
	    	<xsl:when test="@type = 'exception'">
	    		<div class="postresult">
		          Finalization test has thrown an exception: 
		          <xsl:value-of select="@exceptionMessage" />
		          <xsl:if test="@exceptionTrace">
		            <div class="exceptiontrace value expandable" style="display: none;">
		              <xsl:call-template name="formatExceptionTrace">
		                <xsl:with-param name="text" select="@exceptionTrace" />
		              </xsl:call-template>
		            </div>
		          </xsl:if>
		        </div>
	    	</xsl:when>
	    </xsl:choose>
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
        <div class="boxtitle" onMouseDown="boxOrCellMouseDown()" onMouseUp="boxMouseUp(this, event)" onMouseOver="this.parentNode.style.borderStyle='dashed'; this.parentNode.style.borderColor='#000';">
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
            <xsl:copy-of select="$title" />
          </span>
          <xsl:if test="$titleRight">
            <span class="boxtitleright">
              <xsl:copy-of select="$titleRight" />
            </span>
          </xsl:if>
        </div>
        <div class="boxcontent">
          <xsl:copy-of select="$content" />
        </div>
      </div>
    </xsl:template>
    <xsl:template name="scriptlink">
      <xsl:param name="line" />
      <xsl:param name="suite" />
      <xsl:param name="class" />
      <a title="Jump to this command in the test script (works only in the Eclipse-internal browser!)" onMouseUp="event.stopPropagation();">
        <xsl:attribute name="class">
          <xsl:value-of select="$class" />
        </xsl:attribute>
        <xsl:choose>
          <xsl:when test="$line">
            <xsl:attribute name="href">
              <xsl:value-of select="concat('integrity://', $suite, '#', $line)" />
            </xsl:attribute>
          </xsl:when>
          <xsl:otherwise>
            <xsl:attribute name="href">
              <xsl:value-of select="concat('integrity://', $suite)" />
            </xsl:attribute>
          </xsl:otherwise>
        </xsl:choose>
      </a>
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
        <xsl:value-of select="concat($hours, 'h')" />
      </xsl:if>
      <xsl:text />
      <xsl:if test="$minutes &gt; 0">
        <xsl:if test="$hours &gt; 0">
          <xsl:text />
        </xsl:if>
        <xsl:value-of select="concat($minutes, 'm')" />
      </xsl:if>
      <xsl:text />
      <xsl:if test="$seconds &gt; 0">
        <xsl:if test="$hours &gt; 0 or $minutes &gt; 0">
          <xsl:text />
        </xsl:if>
        <xsl:value-of select="concat($seconds, 's')" />
      </xsl:if>
      <xsl:text />
      <xsl:if test="$msecs &gt; 0">
        <xsl:choose>
          <xsl:when test="$hours &gt; 0 or $minutes &gt; 0 or $seconds &gt; 0">
            <xsl:text />
            <xsl:value-of select="concat(round($msecs), 'ms')" />
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="concat(round($value), 'ms')" />
          </xsl:otherwise>
        </xsl:choose>
      </xsl:if>
    </xsl:template>
    <xsl:template name="fixSpaces">
      <xsl:param name="text" />
      <xsl:value-of select="$text" />
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
    <xsl:template name="processFormattedString">
      <xsl:param name="text" />
      <xsl:choose>
        <xsl:when test="starts-with($text, '[FORMATTED]')">
          <xsl:call-template name="processFormattedStringRecursive">
            <xsl:with-param name="text" select="substring-after($text, '[FORMATTED]')" />
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$text" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
    <xsl:template name="processFormattedStringRecursive">
      <xsl:param name="text" />
      <xsl:choose>
        <xsl:when test="contains($text, '[')">
          <xsl:value-of select="substring-before($text, '[')" />
          <xsl:variable name="wholeTrailingText">
            <xsl:value-of select="substring-after($text, '[')" />
          </xsl:variable>
          <xsl:choose>
            <xsl:when test="starts-with($wholeTrailingText, '[')">
              <xsl:text>[</xsl:text>
              <xsl:call-template name="processFormattedStringRecursive">
                <xsl:with-param name="text" select="substring-after($wholeTrailingText, '[')" />
              </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
              <xsl:variable name="preToken">
                <xsl:value-of select="substring-before($wholeTrailingText, ']')" />
              </xsl:variable>
              <xsl:variable name="trailingText">
                <xsl:value-of select="substring-after($wholeTrailingText, ']')" />
              </xsl:variable>
              <xsl:variable name="token">
                <xsl:choose>
                  <xsl:when test="contains($preToken, '|')">
                    <xsl:value-of select="substring-before($preToken, '|')" />
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:value-of select="$preToken" />
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:variable>
              <xsl:variable name="replacement">
                <xsl:value-of select="substring-after($preToken, '|')" />
              </xsl:variable>
              <xsl:choose>
	              <xsl:when test="$token = 'NL' or $token = 'T'">
	                <xsl:choose>
	                  <xsl:when test="$token = 'NL'">
	                    <br />
	                  </xsl:when>
	                  <xsl:when test="$token = 'T'">
	                    <xsl:text>    </xsl:text>
	                  </xsl:when>
	                </xsl:choose>
	                <xsl:call-template name="processFormattedStringRecursive">
	                  <xsl:with-param name="text" select="$trailingText" />
	                </xsl:call-template>
	              </xsl:when>
	              <xsl:when test="$token = 'UL' or $token = 'B' or $token = 'I'">
	                <xsl:variable name="innerText">
	                  <xsl:value-of select="substring-before($trailingText, concat('[/', $token, ']'))" />
	                </xsl:variable>
	                <xsl:choose>
	                  <xsl:when test="$token = 'UL'">
	                    <span class="underline">
	                      <xsl:call-template name="processFormattedStringRecursive">
	                        <xsl:with-param name="text" select="$innerText" />
	                      </xsl:call-template>
	                    </span>
	                  </xsl:when>
	                  <xsl:when test="$token = 'B'">
	                    <span class="bold">
	                      <xsl:call-template name="processFormattedStringRecursive">
	                        <xsl:with-param name="text" select="$innerText" />
	                      </xsl:call-template>
	                    </span>
	                  </xsl:when>
	                  <xsl:when test="$token = 'I'">
	                    <span class="italic">
	                      <xsl:call-template name="processFormattedStringRecursive">
	                        <xsl:with-param name="text" select="$innerText" />
	                      </xsl:call-template>
	                    </span>
	                  </xsl:when>
	                </xsl:choose>
	                <xsl:call-template name="processFormattedStringRecursive">
	                  <xsl:with-param name="text" select="substring-after($trailingText, concat('[/', $token, ']'))" />
	                </xsl:call-template>
	              </xsl:when>
	          </xsl:choose>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$text" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
    <xsl:template name="stripFormattedString">
      <xsl:param name="text" />
      <xsl:choose>
        <xsl:when test="starts-with($text, '[FORMATTED]')">
          <xsl:call-template name="stripFormattedStringRecursive">
            <xsl:with-param name="text" select="substring-after($text, '[FORMATTED]')" />
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$text" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
    <xsl:template name="stripFormattedStringRecursive">
      <xsl:param name="text" />
      <xsl:choose>
        <xsl:when test="contains($text, '[')">
          <xsl:value-of select="substring-before($text, '[')" />
          <xsl:variable name="wholeTrailingText">
            <xsl:value-of select="substring-after($text, '[')" />
          </xsl:variable>
          <xsl:choose>
            <xsl:when test="starts-with($wholeTrailingText, '[')">
              <xsl:text>[</xsl:text>
              <xsl:call-template name="stripFormattedStringRecursive">
                <xsl:with-param name="text" select="substring-after($wholeTrailingText, '[')" />
              </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
              <xsl:variable name="preToken">
                <xsl:value-of select="substring-before($wholeTrailingText, ']')" />
              </xsl:variable>
              <xsl:variable name="trailingText">
                <xsl:value-of select="substring-after($wholeTrailingText, ']')" />
              </xsl:variable>
              <xsl:variable name="replacement">
                <xsl:value-of select="substring-after($preToken, '|')" />
              </xsl:variable>
              <xsl:if test="$replacement != ''">
                <xsl:value-of select="$replacement" />
              </xsl:if>
              <xsl:call-template name="stripFormattedStringRecursive">
                <xsl:with-param name="text" select="$trailingText" />
              </xsl:call-template>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$text" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
    <xsl:template name="navigationLine">
      <xsl:param name="depth" />
      <xsl:param name="isLast" />
      <xsl:param name="path" />
      <xsl:if test="$depth &gt; 0">
        <xsl:choose>
          <xsl:when test="$depth &gt; 1">
            <xsl:choose>
              <xsl:when test="substring($path, 2 + string-length($path) - $depth, 1) = '0'">
                <div class="nav_line nav_linedown" />
              </xsl:when>
              <xsl:otherwise>
                <div class="nav_line" />
              </xsl:otherwise>
            </xsl:choose>
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
          <xsl:with-param name="path" select="$path" />
        </xsl:call-template>
      </xsl:if>
    </xsl:template>
    <xsl:template name="formattedComparisonResult">
      <xsl:choose>
        <xsl:when test="@type = 'success'">
          <span class="value">
            <xsl:if test="@value">
              <xsl:call-template name="processFormattedString">
                <xsl:with-param name="text" select="@value" />
              </xsl:call-template>
            </xsl:if>
          </span>
        </xsl:when>
        <xsl:when test="@type = 'failure'">
          <span class="value">
            <xsl:if test="@value">
              <xsl:call-template name="processFormattedString">
                <xsl:with-param name="text" select="@value" />
              </xsl:call-template>
            </xsl:if>
          </span>
          <span class="comparisondivider">
            <br />
            <hr />
            <em>expected:</em>
            <br />
          </span>
          <span class="value">
            <xsl:if test="@expectedValue">
              <xsl:call-template name="processFormattedString">
                <xsl:with-param name="text" select="@expectedValue" />
              </xsl:call-template>
            </xsl:if>
          </span>
        </xsl:when>
      </xsl:choose>
    </xsl:template>
    <xsl:template name="navigationSuite">
      <xsl:param name="depth" />
      <xsl:param name="path" />
      <xsl:param name="siblingCount" />
      <div>
        <xsl:variable name="result">
          <xsl:choose>
            <xsl:when test="result/@exceptionCount &gt; 0">exception</xsl:when>
            <xsl:when test="result/@failureCount &gt; 0">failure</xsl:when>
            <xsl:otherwise>success</xsl:otherwise>
          </xsl:choose>
        </xsl:variable>
        <xsl:variable name="nextPath">
          <xsl:choose>
            <xsl:when test="@display = 'inline'">
              <xsl:value-of select="$path" />
            </xsl:when>
            <xsl:when test="$siblingCount = 0">
              <xsl:value-of select="concat($path, '1')" />
            </xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="concat($path, '0')" />
            </xsl:otherwise>
          </xsl:choose>
        </xsl:variable>
        <xsl:choose>
          <xsl:when test="@display = 'inline'">
            <xsl:attribute name="class">
              <xsl:value-of select="concat('nav_suite nav_suite', $result)" />
            </xsl:attribute>
            <xsl:attribute name="style">
              <xsl:value-of select="'background-image: none'" />
            </xsl:attribute>
          </xsl:when>
          <xsl:otherwise>
            <xsl:attribute name="class">
              <xsl:value-of select="concat('nav_suite nav_suite', $result)" />
            </xsl:attribute>
            <xsl:attribute name="style">
              <xsl:value-of select="concat('background-position: ', $depth * 16 - 8, 'px 0px;')" />
            </xsl:attribute>
            <xsl:call-template name="navigationLine">
              <xsl:with-param name="depth" select="$depth" />
              <xsl:with-param name="path" select="$path" />
              <xsl:with-param name="isLast" select="$siblingCount = 0" />
            </xsl:call-template>
            <div class="nav_suitetitle">
              <xsl:variable name="linktitle">
                <xsl:choose>
                  <xsl:when test="@title">
                    <xsl:value-of select="concat(@title, ' (', @name, ')')" />
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:value-of select="@name" />
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:variable>
              <a>
                <xsl:attribute name="href">
                  <xsl:value-of select="concat('#i', @id)" />
                </xsl:attribute>
                <xsl:attribute name="title">
                  <xsl:value-of select="$linktitle" />
                </xsl:attribute>
                <xsl:choose>
                  <xsl:when test="@title">
                    <xsl:value-of select="@title" />
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:call-template name="simpleSuiteName">
                      <xsl:with-param name="fullSuiteName" select="@name" />
                    </xsl:call-template>
                  </xsl:otherwise>
                </xsl:choose>
              </a>
            </div>
            <div>
              <xsl:attribute name="class">
                <xsl:value-of select="concat('nav_suiteresult nav_suite', $result)" />
              </xsl:attribute>
              <xsl:call-template name="suiteResultSummary" />
            </div>
          </xsl:otherwise>
        </xsl:choose>
        <xsl:for-each select="setup/suite">
          <xsl:variable name="siblingCountToAdd">
            <xsl:choose>
              <xsl:when test="../../@display = 'inline'">
                <xsl:value-of select="$siblingCount" />
              </xsl:when>
              <xsl:otherwise>0</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:variable name="nextSiblingCount" select="$siblingCountToAdd + (count(following-sibling::suite[not(@display = 'inline')]) + count(following-sibling::suite//suite[not(@display = 'inline')])) + count(../../statements//suite[not(@display='inline')]) + count(../../teardown//suite[not(@display='inline')])" />
          <xsl:variable name="additionalDepth">
            <xsl:choose>
              <xsl:when test="@display = 'inline'">0</xsl:when>
              <xsl:otherwise>1</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:call-template name="navigationSuite">
            <xsl:with-param name="depth" select="$depth + $additionalDepth" />
            <xsl:with-param name="path" select="$nextPath" />
            <xsl:with-param name="siblingCount" select="$nextSiblingCount" />
          </xsl:call-template>
        </xsl:for-each>
        <xsl:for-each select="statements/suite">
          <xsl:variable name="siblingCountToAdd">
            <xsl:choose>
              <xsl:when test="../../@display = 'inline'">
                <xsl:value-of select="$siblingCount" />
              </xsl:when>
              <xsl:otherwise>0</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:variable name="nextSiblingCount" select="$siblingCountToAdd + (count(following-sibling::suite[not(@display = 'inline')]) + count(following-sibling::suite//suite[not(@display = 'inline')])) + count(../../teardown//suite[not(@display='inline')])" />
          <xsl:variable name="additionalDepth">
            <xsl:choose>
              <xsl:when test="@display = 'inline'">0</xsl:when>
              <xsl:otherwise>1</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:call-template name="navigationSuite">
            <xsl:with-param name="depth" select="$depth + $additionalDepth" />
            <xsl:with-param name="path" select="$nextPath" />
            <xsl:with-param name="siblingCount" select="$nextSiblingCount" />
          </xsl:call-template>
        </xsl:for-each>
        <xsl:for-each select="teardown/suite">
          <xsl:variable name="siblingCountToAdd">
            <xsl:choose>
              <xsl:when test="../../@display = 'inline'">
                <xsl:value-of select="$siblingCount" />
              </xsl:when>
              <xsl:otherwise>0</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:variable name="nextSiblingCount" select="$siblingCountToAdd + (count(following-sibling::suite[not(@display = 'inline')]) + count(following-sibling::suite//suite[not(@display = 'inline')]))" />
          <xsl:variable name="additionalDepth">
            <xsl:choose>
              <xsl:when test="@display = 'inline'">0</xsl:when>
              <xsl:otherwise>1</xsl:otherwise>
            </xsl:choose>
          </xsl:variable>
          <xsl:call-template name="navigationSuite">
            <xsl:with-param name="depth" select="$depth + $additionalDepth" />
            <xsl:with-param name="path" select="$nextPath" />
            <xsl:with-param name="siblingCount" select="$nextSiblingCount" />
          </xsl:call-template>
        </xsl:for-each>
      </div>
    </xsl:template>
    <xsl:template name="simpleSuiteName">
      <xsl:param name="fullSuiteName" />
      <xsl:variable name="simpleSuiteName" select="substring-after($fullSuiteName, '.')" />
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
      <xsl:variable name="firstPart" select="substring-before($fullSuiteName, '.')" />
      <xsl:variable name="lastPart" select="substring-after($fullSuiteName, '.')" />
      <xsl:choose>
        <xsl:when test="$lastPart">
          <xsl:call-template name="suitePackageName">
            <xsl:with-param name="fullSuiteName" select="$lastPart" />
            <xsl:with-param name="packageName" select="concat($packageName, '.', $firstPart)" />
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$packageName" />
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
        !
      </xsl:if>
    </xsl:template>
    <xsl:template name="suitePath">
      <xsl:param name="path" />
      <xsl:param name="prefix" />
      <xsl:choose>
        <xsl:when test="name() = 'suite'">
          <xsl:variable name="currentSuiteName" select="@name" />
          <xsl:for-each select="../../.">
            <xsl:call-template name="suitePath">
              <xsl:with-param name="path" select="concat($currentSuiteName, ':', $path)" />
              <xsl:with-param name="prefix" select="$prefix" />
            </xsl:call-template>
          </xsl:for-each>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="concat($prefix, $path)" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
  </xsl:stylesheet>