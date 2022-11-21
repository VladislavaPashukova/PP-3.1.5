$(async function () {
    await thisUser();
});

async function thisUser() {
    fetch("http://localhost:8080/allUser")
        .then(res => res.json())
        .then(data => {
            $('#headName').append(data.email);
            let roles = data.roles.map(role => " " + role.role.substring(5));
            $('#headRole').append(roles);

            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>
                    <td>${data.email}</td>
                    <td>${roles}</td>)`;
            $('#allUserPanel').append(user);
        })
}


