const domain = 'http://localhost:8080';
const getAllUserEndpoint = `${domain}/api/user/all`;
const deleteUserEndpoint = `${domain}/api/user/delete`;

async function getUserHandler() {
    try {
        const response = await fetch(getAllUserEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        let msg = '';
        for (let i = 0; i < data.data.length; i++) {
            msg += `
                <tr data-id="${data.data[i].id}">
                    <td><input type="checkbox"></td>
                    <td>${data.data[i].fullname}</td>
                    <td>${data.data[i].gender}</td>
                    <td>${data.data[i].dateOfBirth}</td>
                    <td>${data.data[i].phone}</td>
                    <td>
                        <a href="/admin/user/${data.data[i].id}"><i class="fa-solid fa-pen"></i></a>
                        <button type="button" class="delete-btn"><i class="fa-solid fa-trash delete-user"></i></button>
                    </td>
                </tr>
            `;
        }
        document.getElementById("data-container").innerHTML = msg;
    } catch (error) {
        console.error('Fetch error', error);
    }
}

async function deleteUser(userId, rowElement) {
    try {
        const response = await fetch(`${deleteUserEndpoint}/${userId}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            rowElement.remove();
            alert('Xóa thành công');
        } else {
            alert('Không thể xóa, xóa thất bại');
        }
    } catch (error) {
        console.error('Lỗi khi xóa user:', error);
        alert('Đã xảy ra lỗi khi xóa user');
    }
}

window.addEventListener('load', getUserHandler);
document.getElementById('users').addEventListener('click', function (event) {
    if (event.target.classList.contains('delete-user')) {
        const rowElement = event.target.closest('tr');
        const userId = rowElement.dataset.id;
        if (confirm("Bạn có chắc muốn xóa không?"))
            deleteUser(userId, rowElement);
    }
});
