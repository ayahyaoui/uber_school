// graphics
document.body.setAttribute("style", "background-image : url('img1.jpg');  background-repeat: no-repeat;  background-size: cover;");
let div1 = document.createElement("DIV");
div1.setAttribute("class", "left_div");
div1.setAttribute("style", "background-color : #b3ccff ; width : 300px ; height : 400px ; padding : 50px ; border : 0% ; margin : 100px 100px 100px 100px ; display : flex ; justify-content : center ; float : right; ");
let div2 = document.createElement("DIV");
div2.setAttribute("class", "left_title");
div2.setAttribute("style", " float : left; width = 50% ");
let txt1 = document.createElement("H1");
txt1.setAttribute("style", "font-size:900% ; color : white; margin-top : 250px ;  margin-left : 15% ; margin_bottom : 0% ; padding : 0px ; border : 0px ; font-family : Tahoma ; display : bottom ; float : left; position : absolute; ");
txt1.textContent="Uber";
let txt2 = document.createElement("H1");
txt2.setAttribute("style", "font-size:300% ; color : white; margin-top : 410px ; margin-left : 16% ; padding : 0px ; border : 0px ; font-family : Tahoma ; display : top ; float : left; position : absolute;");
txt2.textContent="School";
div2.appendChild(txt1);
div2.appendChild(txt2);
document.body.appendChild(div1);
document.body.appendChild(div2);

// login
let login_form = document.createElement("FORM");
login_form.setAttribute("action" , "");
login_form.setAttribute("method" , "post");

let div_u = document.createElement("DIV");
let login_label_u = document.createElement("LABEL");
login_label_u.setAttribute("for", "username");
login_label_u.textContent = "username";
div_u.appendChild(login_label_u);
div_u.appendChild(document.createElement("BR"));

let login_field_u = document.createElement("INPUT");
login_field_u.setAttribute("type", "text");
login_field_u.setAttribute("id", "username");
login_field_u.setAttribute("name", "username");
div_u.appendChild(login_field_u);
div_u.appendChild(document.createElement("BR"));

let div_p = document.createElement("DIV");
let login_label_p = document.createElement("LABEL");
login_label_p.setAttribute("for", "password");
login_label_p.textContent = "password";
div_p.appendChild(login_label_p);
div_p.appendChild(document.createElement("BR"));

let login_field_p = document.createElement("INPUT");
login_field_p.setAttribute("type", "text");
login_field_p.setAttribute("id", "password");
login_field_p.setAttribute("name", "password");
div_p.appendChild(login_field_p);
div_p.appendChild(document.createElement("BR"));

let login_button = document.createElement("INPUT");
login_button.setAttribute("type", "submit");
login_button.setAttribute("value", "login");

login_form.appendChild(div_u);
login_form.appendChild(document.createElement("BR"));
login_form.appendChild(div_p);
login_form.appendChild(document.createElement("BR"));
login_form.appendChild(login_button);

div1.appendChild(login_form);

// event listener
function authentification(event){
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'profile?username='+login_field_u.value+'&password='+login_field_p.value);
	xhr.send();
	xhr.addEventListener("readystatechange", function(event){
		if (xhr.readyState === XMLHttpRequest.DONE){
			let jresp = JSON.parse(xhr.response);
			console.log(jresp.user_name);
			cont_login(jresp);
		}
	});
}

login_button.addEventListener("click", function(event){event.preventDefault();  authentification(event);});

// continuation
function cont_login(jresp){
	document.body.setAttribute("style", "background-image : none; background-color : white; ");
	document.body.removeChild(div1);
	document.body.removeChild(div2);
	let user_info = document.createElement("HEADER");
	user_info.setAttribute("style", "background-color : #b3ccff ; width : 100% ; padding : 10px ; box-shadow: 10px 10px 5px grey ; ");
	let un = document.createElement("H5");
	un.textContent=jresp.user_name;
	user_info.appendChild(un);
	document.body.appendChild(user_info);
	
	// map
	let left_window = document.createElement("DIV");
	map = document.createElement("DIV");
	map.setAttribute("id", "map");
	left_window.setAttribute("style", "width : 65% ; height : 1000px ; float : left; ");
	map.setAttribute("style", "width : 100% ; height : 100% ; ");
	left_window.appendChild(map);
	document.body.appendChild(left_window);

	// liste rendez-vous
	let right_window = document.createElement("DIV");
	right_window.setAttribute("style", "width : 30% ; padding : 20px ;  float : right; ");
	let res_title = document.createElement("DIV");
	res_title.setAttribute("style", "width : 100% ; height : 50px ; padding : 0px ; ");
	let rt = document.createElement("H2");
	rt.textContent="Reservations";
	res_title.appendChild(rt);
	right_window.appendChild(res_title);
	//right_window.appendChild(document.createElement("BR"));
	let rv = document.createElement("TABLE");
	//rv.appendChild(document.createElement("BR"));
	console.log(jresp.reservations);
	for(r of jresp.reservations){
		let text = document.createElement("TR");	
		let da = document.createElement("TD");
		da.setAttribute("style", "padding-right : 20px");
		da.textContent=r.date;
		let dr = document.createElement("TD");
		dr.textContent=r.driver_name;
		//dr.setAttribute("style", "padding : 20px");
		text.appendChild(da);
		text.appendChild(dr);
		rv.appendChild(text);
	}
	right_window.appendChild(rv);
	document.body.appendChild(right_window);
	
	/*
	// google map api script
	let s = document.createElement('script');
    s.type = 'text/javascript';
	s.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyD_gzYM0zyzNwR5OOfYpJam9P5XbGSLRXQ&callback=initMap&libraries=&v=weekly" ;
    s.async = true;
    document.body.appendChild(s);
	*/
}

function initMap(){	
	console.log("map init");
	console.log(document.getElementById("map"));
	let m = new google.maps.Map(document.getElementById("map"), {center: { lat: 48.856614, lng: 2.3522219 }, zoom: 12, });

	//let marker = new google.maps.Marker([position: location, map: m]);	
}
