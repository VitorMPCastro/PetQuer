function toggleUserTypeFields() {
    let userType = document.getElementById("userType").value;
    document.getElementById("individualFields").style.display = userType === "individual" || userType === "both" ? "block" : "none";
    document.getElementById("companyFields").style.display = userType === "company" || userType === "both" ? "block" : "none";
}