// Smooth scrolling for navigation links
document.querySelectorAll('.nav-links a').forEach(anchor => {
  anchor.addEventListener('click', function(e) {
    e.preventDefault();

    const targetId = this.getAttribute('href').substring(1);
    const targetElement = document.getElementById(targetId);

    window.scrollTo({
      top: targetElement.offsetTop - 50,  // Adjust scroll position if needed
      behavior: 'smooth'
    });
  });
});

// Optional: Fade-in effect for content on page load
window.addEventListener("load", function () {
  const welcomeContent = document.querySelector(".welcome-content");

  // Initially set opacity to 0 for fade-in effect
  welcomeContent.style.opacity = 0;
  welcomeContent.style.transition = "opacity 1s"; // Smooth fade-in transition

  // After a short delay, set opacity to 1 to trigger fade-in
  setTimeout(() => {
    welcomeContent.style.opacity = 1;
  }, 500); // 500ms delay before fading in
});



// Form validation
document.querySelector("form").addEventListener("submit", function(e) {
  // Get form values
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const message = document.getElementById("message").value.trim();
  
  // Validate form
  let valid = true;

  // Name validation
  if (name === "") {
    alert("Please enter your name.");
    valid = false;
  }

  // Email validation
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  if (email === "" || !emailPattern.test(email)) {
    alert("Please enter a valid email.");
    valid = false;
  }

  // Message validation
  if (message === "") {
    alert("Please enter your message.");
    valid = false;
  }

  if (!valid) {
    e.preventDefault();  // Prevent form submission if validation fails
  }
});

// Optional: Adding a simple animation on page load
window.addEventListener("load", function() {
  const welcomeContent = document.querySelector(".welcome-content");
  welcomeContent.style.opacity = 0;
  welcomeContent.style.transition = "opacity 1s";

  setTimeout(() => {
    welcomeContent.style.opacity = 1;
  }, 500);
});
