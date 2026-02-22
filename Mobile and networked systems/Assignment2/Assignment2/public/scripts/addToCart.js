function addToCart(value, message, product) {
    if (value >= 0 && Number.isInteger(Number(value))) {
        fetch(`/addItemToCard/${product}/${value}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            message.innerHTML = `You have successfully ordered ${value} bags of ${product}!`;
        })
        .catch(error => {
            console.error('Error adding item to cart:', error);
            message.innerHTML = "There was an error adding the item to your cart.";
        });
    } else {
        message.innerHTML = "Please enter a valid non-negative integer.";
    }
}