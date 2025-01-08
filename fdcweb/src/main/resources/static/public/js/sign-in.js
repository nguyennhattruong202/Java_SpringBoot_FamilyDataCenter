const domain = 'http://localhost:8080';
const signInEndpoint = domain + '/api/sign-in';
async function signInHandler() {
    const signInForm = {
        phone: document.getElementById("phone").value,
        password: document.getElementById("password").value
    };
    try {
        const response = await fetch(signInEndpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(signInForm)
        });
        if (response.status === 200) {
            window.location.href = domain + '/admin/dashboard';
        } else {
            alert('Sign in failded');
            throw new Error('Server returned an error');
        }
    } catch (error) {
        alert('Error during sign in');
    }
}

document.getElementById('form__sign-in').addEventListener('submit', (event) => {
    event.preventDefault();
    signInHandler();
});