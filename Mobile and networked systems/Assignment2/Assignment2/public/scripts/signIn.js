async function signIn() {
    let username = prompt("Please enter your username", "admin");
    let password = prompt("Please enter your password", "123");

    if (username == null || password == null || username.length == 0 || password.length == 0) {
        return;
    }

    const url = `http://localhost:23500/login?username=${username}&password=${password}`;

    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain',
        }
    }).catch((error) => { 
        console.log("Network error:", error);
    });

    if (!response.ok) {
        alert("Invalid login");
        return;
    }

    // Make a second fetch request to checkout
    // await not needed because of .thens
    fetch(`http://localhost:23500/checkout`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    }).then(response => response.text())
      .then(responseText => {prompt(responseText)});
}