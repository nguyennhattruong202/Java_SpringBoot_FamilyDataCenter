const createAccountEndpoint = 'http://localhost:8080/api/user/create-account';

let fullnameElement = document.getElementById('fullname');
let genderCheckedElement = document.querySelector('input[name="gender"]:checked');
let dateOfBirthElement = document.getElementById('dateOfBirth');
let phoneElement = document.getElementById('phone');
let genderElements = document.getElementsByName('gender');

document.getElementById('userForm').addEventListener('submit', (event) => {
    event.preventDefault();
    demoCreateAccountHandler();
});

function demoCreateAccountHandler() {
    let gender = genderCheckedElement.value;
    for (i = 0; i < genderElements.length; i++) {
        if (genderElements[i].checked === true)
            gender = genderElements[i].value;
    }
    const formData = {
        fullname: fullnameElement.value,
        gender: gender,
        dateOfBirth: dateOfBirthElement.value,
        phone: phoneElement.value
    }
    console.log(formData);
    alert('Submit OK');
    passwordHandler();
}

async function createAccountHandler() {
    let gender = genderCheckedElement.value;
    for (i = 0; i < genderElements.length; i++) {
        if (genderElements[i].checked === true)
            gender = genderElements[i].value;
    }
    const formData = {
        fullname: fullnameElement.value,
        gender: gender,
        dateOfBirth: dateOfBirthElement.value,
        phone: phoneElement.value
    }
    try {
        const response = await fetch(createAccountEndpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });
        if (response.status === 201) {
            const result = await response.json();
            console.log('Submit successful');
            console.log(result);

        }
        else {
            throw new Error('Error HTTP');
        }
    } catch (error) {
        alert('Error!');
    }
}

function passwordHandler() {
    window.location.href = '/templates/public/create-password.html';
    document.getElementById('phone-password').value = '0865761892';
}

