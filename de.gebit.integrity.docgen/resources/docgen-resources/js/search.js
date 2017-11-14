window.onload = function(event){ 
	document.getElementById('searchbutton').onclick = function(event) {
		search(document.getElementById('searchtext').value);
	};
	document.getElementById('searchtext').addEventListener('keyup', function(event) {
		event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("searchbutton").click();
    }
	});
}

var lunrIndex = lunr.Index.load(lunrIndexJSON.index);

function search(query) {
	try {
		var resultContainer = document.getElementById('searchresults');
		clearResults(resultContainer);
		
    results = lunrIndex.search(query);
    
    if(results.length == 0) {
    	showNoResult(resultContainer);
    } else {    
	    results.forEach(function (result) {
		    addResult(resultContainer, result);
		  });
		}
  } catch(e) {
    if (e instanceof lunr.QueryParseError) {
      displayQueryError(query, e);
      return;
    } else {
      throw e;
    }
  }
}

function clearResults(container) {
	while(container.firstChild){
		container.removeChild(container.firstChild);
	}
}

function addResult(container, result) {
	var resultTokens = "";
	for (token in result.matchData.metadata) {
		if(resultTokens != "") {
			resultTokens = resultTokens + " ";
		}
		resultTokens = resultTokens + token;
	}
	var resultUrl = "packages/" + result.ref + ".html" + "#" + encodeURIComponent(resultTokens);
	var resultIdentifier = "result_" + Math.floor(Math.random() * 10000000000);
	
	var resultDiv = document.createElement('div');
	resultDiv.setAttribute('class', 'searchresult');
	var packageNameDiv = document.createElement('div');
	packageNameDiv.setAttribute('class', 'packagename');
	var packageNameA = document.createElement('a');
	packageNameA.href = resultUrl;
	packageNameA.textContent = result.ref;
	packageNameDiv.appendChild(packageNameA);
	resultDiv.appendChild(packageNameDiv);
	var hitCountDiv = document.createElement('div');
	hitCountDiv.setAttribute('class', 'searchhits');
	var hitCountText = document.createElement('span');
	hitCountText.id = resultIdentifier + "_hitcount";
	hitCountDiv.appendChild(hitCountText);
	var hitJumpPrev = document.createElement('button');
	hitJumpPrev.setAttribute('class', 'searchhitprev');
	hitCountDiv.appendChild(hitJumpPrev);
	var hitJumpNext = document.createElement('button');
	hitJumpNext.setAttribute('class', 'searchhitnext');
	hitCountDiv.appendChild(hitJumpNext);
	resultDiv.appendChild(hitCountDiv);
	var resultDocumentFrame = document.createElement('iframe');
	resultDocumentFrame.name = resultIdentifier;
	resultDocumentFrame.src = resultUrl;	
	resultDiv.appendChild(resultDocumentFrame);
	container.appendChild(resultDiv);
	
	hitJumpPrev.onclick = function(event) {
		resultDocumentFrame.contentWindow.postMessage("jumpToPrev", "*");
	};
	hitJumpNext.onclick = function(event) {
		resultDocumentFrame.contentWindow.postMessage("jumpToNext", "*");
	};
}

function showNoResult(container) {
	var innerDiv = document.createElement('div');
	innerDiv.setAttribute('class', 'emptyresult');
	innerDiv.textContent = "No results found";
	container.appendChild(innerDiv);
}

window.addEventListener('message', function(event) {
	var parts = event.data.split("|");
	var hitCountText = document.getElementById(parts[0] + "_hitcount");
	if(hitCountText) {
		hitCountText.textContent = parts[1];
	}
}); 