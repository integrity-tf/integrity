var lunrIndex = lunr.Index.load(lunrIndexJSON.index);

function search(query) {
	try {
    results = lunrIndex.search(query);
    
    results.forEach(function (result) {
	    alert(JSON.stringify(result));	        
	  });
  } catch(e) {
    if (e instanceof lunr.QueryParseError) {
      displayQueryError(query, e)
      return
    } else {
      throw e
    }
  }
}