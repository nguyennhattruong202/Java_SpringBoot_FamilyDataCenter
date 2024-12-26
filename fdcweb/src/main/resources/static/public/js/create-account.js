const domain = 'http://localhost:8080';
const createAccountEndpoint = domain + '/api/user/create-account';
const createPasswordEnpoint = domain + '/api/auth-credentials';

let fullnameElement = document.getElementById('fullname');
let dateOfBirthElement = document.getElementById('date-of-birth');
let phoneElement = document.getElementById('phone');
let genderElements = document.getElementsByName('gender');
let passwordElement = document.getElementById('password');

let genderValue = () => {
    let gender = '';
    for (let i = 0; i < genderElements.length; i++) {
        if (genderElements[i].checked) {
            gender = genderElements[i].value;
        }
    }
    return gender;
};

async function createPasswordHandler(userId) {
    const infoPassword = {
        phone: phoneElement.value,
        password: passwordElement.value
    };
    try {
        const response = await fetch(createPasswordEnpoint + '/' + userId, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(infoPassword)
        });
        if (response.status === 200) {
            alert('Create account successful');
        } else {
            alert('Create password failded');
            throw new Error('Server returned an error');
        }
    } catch (error) {
        alert('Erorr during create password');
    }
}

async function createAccountHandler() {
    const infoAccount = {
        fullname: fullnameElement.value,
        gender: genderValue(),
        dateOfBirth: dateOfBirthElement.value,
        phone: phoneElement.value
    };
    try {
        const response = await fetch(createAccountEndpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(infoAccount)
        });
        if (response.status === 201) {
            const result = await response.json();
            await createPasswordHandler(result.data.id);
        } else {
            alert('Create account failded');
            throw new Error('Server returned an error');
        }
    } catch (error) {
        alert('Error during create account');
    }
}

document.getElementById('user-form').addEventListener('submit', (event) => {
    event.preventDefault();
    createAccountHandler();
});