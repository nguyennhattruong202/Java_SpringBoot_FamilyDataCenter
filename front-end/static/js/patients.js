function closeAlert() {
    document.getElementById("alert-box").style.display = "none";
}
function toggleDeletePatientModal(patientId) {
    let modal = document.getElementById(`delete-modal-${patientId}`);
    if (modal.classList.contains("hidden")) {
        modal.classList.remove("hidden");
    } else {
        modal.classList.add("hidden");
    }
}
function checkBoxAll() {
    const checkboxAll = document.getElementById("checkbox-all");
    const checkboxes = document.querySelectorAll(".patient-checkbox");
    if (checkboxAll.checked) {
        checkboxes.forEach(checkbox => {
            checkbox.checked = true;
        });
    }
    else {
        checkboxes.forEach(checkbox => {
            checkbox.checked = false;
        });
    }
}
