const createAccountEndpoint = 'http://localhost:8080/api/user/create-account';

async function createAccountHandle(endpoint) {
    const formData = {
        fullname: document.getElementById('fullname').value,
        gender: document.getElementById('gender').value,
        dateOfBirth: document.getElementById('dateOfBirth').value,
        phone: document.getElementById('phone').value
    };
    try {
        const response = await fetch(endpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        if (!response.ok) {
            throw new Error(`Lỗi HTTP! Mã trạng thái: ${response.status}`);
        }
        console.log('Success:', data);
        alert('Form submitted successfully!');
    } catch (error) {
        console.error('Error:', error);
        alert('Error submitting form.');
    }
}

document.getElementById('userForm').addEventListener('submit', createAccountHandle(createAccountEndpoint));