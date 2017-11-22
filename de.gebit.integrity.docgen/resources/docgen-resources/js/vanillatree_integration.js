var tree;
var treeState = {};

function attachTree(target) {
	tree = new VanillaTree(target, null);
	target.addEventListener('vtree-select', (event) => { goToPackage(event.detail.id); });
	populateTree(tree);
	target.addEventListener('vtree-open', (event) => { treeState[event.detail.id] = true; storeTreeState(); });
	target.addEventListener('vtree-close', (event) => { delete treeState[event.detail.id]; storeTreeState(); });
	
	if(history.state) {
		restoreTreeState(history.state.state);
	}
}

function populateTree(tree) {
	var index;
	for (index = 0; index < treeData.length; ++index) {
		tree.add(treeData[index]);
	}
}

function serializeTreeState() {
	var state = "";
	for(key in treeState) {
		if(state != "") {
			state = state + "-";
		}
		state = state + key;
	}
	
	return state;
}

function storeTreeState() {
	var serializedState = serializeTreeState();
	history.replaceState({ state: serializedState }, "");
	var indexLink = document.getElementById("treeindexlink").firstElementChild;
	indexLink.href = indexLink.href.split('#')[0] + "#" + serializedState;
}

function restoreTreeState(stateString) {
	var tokens = stateString.split(/-/);				
	var index;
	for (index = 0; index < tokens.length; ++index) {
		tree.open(tokens[index]);
	}
}

function goToPackage(targetIndex) {
	var targetPackage = treeData[targetIndex];
	
	if(targetPackage.href != null) {
		if(typeof lunrIndex === 'undefined') {
			window.location.href = targetPackage.href + ".html" + "#" + encodeURIComponent(serializeTreeState() + "|");
		} else {
			window.location.href = "packages/" + targetPackage.href + ".html" + "#" + encodeURIComponent(serializeTreeState() + "|");
		}
	} else {
		tree.toggle(targetIndex);
	}
}