document.getElementById('rsvp-form').addEventListener('submit', function(event) {
    event.preventDefault(); // prevent form submission
  
    const form = event.target;
  
    const name = form.name.value.trim();
    const attendingNum = parseInt(form.attendingNum.value, 10);
    const attendingVeg = parseInt(form.attendingVeg.value, 10);
    const attendingNonVeg = parseInt(form.attendingNonVeg.value, 10);
  
    const response = document.getElementById('response');
  
    // Basic validation
    if (!name) {
      response.textContent = 'Please enter a name.';
      response.style.color = 'red';
      return;
    }
  
    if (isNaN(attendingNum) || attendingNum < 0 || attendingNum > 10) {
      response.textContent = 'Please select a valid number of attendees.';
      response.style.color = 'red';
      return;
    }
  
    if (isNaN(attendingVeg) || attendingVeg < 0 || attendingVeg > attendingNum) {
      response.textContent = 'Please select a valid number of vegetarians.';
      response.style.color = 'red';
      return;
    }
  
    if (isNaN(attendingNonVeg) || attendingNonVeg < 0 || attendingNonVeg > attendingNum) {
      response.textContent = 'Please select a valid number of non-vegetarians.';
      response.style.color = 'red';
      return;
    }
  
    if (attendingVeg + attendingNonVeg !== attendingNum) {
      response.textContent = 'Total vegetarians and non-vegetarians must add up to total attendees.';
      response.style.color = 'red';
      return;
    }
  
    fetch('http://localhost:8080/rsvp', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, attendingNum, attendingVeg, attendingNonVeg })
  })
  .then(res => res.text())
  .then(text => {
    response.textContent = text;
    response.style.color = 'green';
    form.reset();
  })
  .catch(err => {
    response.textContent = 'Submission failed.';
    response.style.color = 'red';
  });
  });
  