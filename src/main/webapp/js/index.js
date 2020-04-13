
document.getElementById('submitBtn').addEventListener('click', getApi);

function getApi() {
    fetch('http://ec2-3-19-123-54.us-east-2.compute.amazonaws.com:9999/flashcard')
        .then(response => response.json())
        .then(json => implant(json));
}

function implant(json) {
	
	let searchId = document.getElementById('searchId').value;
	
	document.getElementById('info').innerHTML = " " + json[searchId].id + " " +
	json[searchId].category + " " +
	json[searchId].question + " " +
	json[searchId].answer + " ";
	
	console.log(json);
}

