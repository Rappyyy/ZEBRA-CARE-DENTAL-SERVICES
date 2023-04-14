function returnName() {
  
  const patientName = document.getElementById("patientName").value;
  const dentistName = document.getElementById("dentist").value;
  const contactInfo = document.getElementById("phone").value;
  const address = document.getElementById("address").value;
  const startTime= document.getElementById("startTime").value;
  const endTime= document.getElementById("endTime").value;
  const description = document.getElementById("description").value;
  const service= document.getElementById("service").value;
 
  const newData = {
    "startTime": startTime,
    "endTime": endTime,
    "patientName": patientName,
    "dentistName": dentistName,
    "contactInfo": contactInfo,
    "address": address,
    "description": description,
    "service": service
  }

  axios.post('https://4mier8seu8.execute-api.us-west-2.amazonaws.com/prod/appointments/', newData)
  .then(function (response) {
    // handle success
    alert("Schedule succesfully created!")
    console.log(response);
  window.location.reload();
})
}
// function checkAppointment() {
//   const id = new Object();
//   id.input = document.getElementById("id").value;
//   alert(id.input)
// }