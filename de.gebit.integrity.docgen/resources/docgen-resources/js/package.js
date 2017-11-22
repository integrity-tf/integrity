window.onload = function(event) {
	var showTree = true;
	
	if(window.location.hash) {
		var hashText = decodeURIComponent(window.location.hash).substring(1);
		
		if(window.name && window.name.startsWith("result_")) {
			var treeContainer = document.getElementById('treecontainer');
			treeContainer.parentElement.removeChild(treeContainer);
			showTree = false;
		}
		
		var parts = hashText.split('|');
		var stateText = parts[0];
		var highlightText = parts[1];
		
		if(highlightText.startsWith("highlight_")) {
			var highlightTokens = highlightText.substring(10).split(/[ ,#]+/).filter(Boolean);				
			var context = document.getElementById('maincontainer');
			var marker = new Mark(context);
			marker.mark(highlightTokens, {'diacritics': false, 
				'accuracy': {'value': "exactly", 'limiters': [" ", ".", ",", "\"", ":"]},
				'each': function(element) {
					highlightedElements.push(element);
				},
				'done': function(count) {
					if(parent) {
						parent.postMessage(window.name + "|" + count + " hit" + (count != 1 ? "s" : ""), "*");
					}
					jumpToNext();
				},
			});
		}
	}
	
	if(showTree) {
		attachTree(document.getElementById('packagetree'));
		if(stateText != "") {
			restoreTreeState(stateText);
		}
	}
};

window.addEventListener('message', function(event) {
	if(event.data == "jumpToPrev") {
		jumpToPrev();
	} else if(event.data == "jumpToNext") {
		jumpToNext();
	}
}); 

var highlightedElements = [];
var currentHighlight = -1;

function jumpToNext() {
  if (highlightedElements.length) {
  	var delayed = false;
  	if(currentHighlight >= 0) {
			jumpToClear(highlightedElements[currentHighlight]);
		} else {
			delayed = true;
		}
		currentHighlight += 1
		if(currentHighlight >= highlightedElements.length) {
			currentHighlight = 0;
		}
    jumpToSet(highlightedElements[currentHighlight], delayed);
  }
}

function jumpToPrev() {
  if (highlightedElements.length) {
		jumpToClear(highlightedElements[currentHighlight]);
		currentHighlight -= 1
		if(currentHighlight < 0) {
			currentHighlight = highlightedElements.length - 1;
		}
    jumpToSet(highlightedElements[currentHighlight]);
  }
}

function jumpToClear(element) {
	element.setAttribute('class', '');
}

function jumpToSet(element, delayed) {
	element.setAttribute('class', 'jumpmark');
		
	if(delayed) {
		setTimeout(function(){ scrollIntoVisibility(element); }, 0);
	} else {
		scrollIntoVisibility(element);
	}
}

function scrollIntoVisibility(element) {
	var position = 0;
	var obj = element;
  if (obj.offsetParent) {
    do {
      position += obj.offsetTop;
    } while (obj = obj.offsetParent);
  }
  
  position -= (document.documentElement.clientHeight / 2 - 10);
  if(position < 0) {
  	position = 0;
  }
  
  document.documentElement.scrollTop = position;
}

function toggleHiddenDiv(parentElement) {
	for (var i = 0; i < parentElement.childNodes.length; ++i) {
		var child = parentElement.childNodes[i];
		if (child.className && child.className.includes("hidden")) {
			if (child.style.display == "block") {
				child.style.display = "none";
			} else {
				child.style.display = "block";
			}
		}
	}
}