document.getElementById("friends-filter").selectedIndex = -1;
let cur = document.getElementById("currency-filter").value;

//convert amount of table according to filter
function convertAmount() {
    console.log("Inside Convert");
    let toCurrency = document.getElementById("currency-filter").value;
    let amt;

    for (let index = 1; index < document.getElementById('myTable').rows.length; index++) {
        amt = document.getElementById('myTable').rows[index].cells[4].innerHTML;
        console.log(cur + " to " + toCurrency + " of " + amt);
        console.log("will be = "+toConvert(cur, amt, toCurrency));
        document.getElementById('myTable').rows[index].cells[4].innerHTML = toConvert(cur, amt, toCurrency);
    }
    cur = toCurrency;
}

//for getting index of column
function myFunction(x) {
    i = x.rowIndex
    console.log("Row index is: " + i);
}

//to delete selected row
function deleted() {
    setTimeout(function () {
        console.log("waiting..");
        console.log("Deleted request " + i);
        if (confirm("Do you really want to clear?")) {
            document.getElementById("myTable").deleteRow(i);
        }
        console.log("Deleted successfully");
    }, 200);
}

//to edit a particular row
function editThis() {
    setTimeout(function () {
        console.log("waiting..");
        console.log("Editing request " + i);

        // fillLabel
        document.getElementById("label-item").innerHTML = "<B>Edit expense</B>";
        document.getElementById("add").innerHTML = "Done";

        //fillForm
        document.getElementById("type").value = document.getElementById('myTable').rows[i].cells[0].innerHTML;
        document.getElementById("name").value = document.getElementById('myTable').rows[i].cells[1].innerHTML;
        document.getElementById("friends").value = document.getElementById('myTable').rows[i].cells[2].innerHTML;
        document.getElementById("date").value = document.getElementById('myTable').rows[i].cells[3].innerHTML;
        // document.getElementById("currency").innerHTML=document.getElementById('myTable').rows[i].cells[3].innerHTML;
        document.getElementById("amount").value = document.getElementById('myTable').rows[i].cells[4].innerHTML;

        if (confirm("Do you really want to edit this row?")) {
            document.getElementById("myTable").deleteRow(i);
        }

        console.log("Edited successfull");
    }, 100);
}

//reset to default
function setDefaultValue(){
    document.getElementById("label-item").innerHTML = "Add a new Item:";
    document.getElementById("add").innerHTML = "Add a new Expense";

    //fillForm
    document.getElementById("type").value = "Cash";
    document.getElementById("name").value = "";
    document.getElementById("friends").value = "";
    document.getElementById("date").value = "";
    document.getElementById("currency").innerHTML= "Rupees";
    document.getElementById("amount").value = "";


}

//to add new friend
document.getElementById("addFriend").onclick = function () {
    console.log("Inside add new friend");
    let friends = document.getElementById("friends").innerHTML;

    let new_friend = window.prompt("Enter name of Friend: ");
    if (new_friend === "") {
        alert("Name can't be empty")
    }
    else {
        console.log("name " + new_friend);
        friends += `
            <option>${new_friend}</option>
        ` ;
    }

    document.getElementById("friends").innerHTML = friends;
    document.getElementById("friends-filter").innerHTML = friends;
    document.getElementById("friends-filter").selectedIndex = -1;

}
document.getElementById("add").onclick = function () {
    getAndUpdate();
    setDefaultValue();
    // document.getElementById("myForm").reset();
}

//to read from form and update into table
function getAndUpdate() {
    console.log("Adding to list...");

    let type = document.getElementById("type").value;
    let friend = document.getElementById("friends").value;
    let name = document.getElementById("name").value;
    let date = document.getElementById("date").value;
    let currency = document.getElementById("currency").value;
    let amount = document.getElementById("amount").value;

    if (currency === "Rupees") {
        amount = amount;
    }
    else
        if (currency === "USD") {
            amount = amount * 76;
        }
        else
            if (currency === "EURO") {
                amount = amount * 85
            }

    let tableBody = document.getElementById("tableBody");
    let str = tableBody.innerHTML;
    str += `
                        <tr onclick="myFunction(this)">
                        <td>${type}</td>
                        <td>${name}</td> 
                        <td>${friend}</td>
                        <td>${date}</td>
                        <td>${amount}</td>
                        <td><button class="btn btn-sm btn-info" onclick="editThis()">Edit</button></td>
                        <td><button class="btn btn-sm btn-danger" onclick="deleted()">Delete</button></td> 
                        </tr>`;
    // Populate the table
    tableBody.innerHTML = str;
    // document.getElementById("myform").reset();
}

//to convert amount 
function toConvert(currency, amount, toCurrency) {
    if (toCurrency === "Rupees") {
        if (currency === "Rupees") {
            amount = amount;
        }
        else
            if (currency === "USD") {
                amount = amount * 76.56;
            }
            else
                if (currency === "EURO") {
                    amount = amount * 84.28
                }
    }
    else
        if (toCurrency === "USD") {
            if (currency === "USD") {
                amount = amount;
            }
            else
                if (currency === "EURO") {
                    amount = amount * 1.1;
                }
                else
                    if (currency === "Rupees") {
                        amount = amount * 0.013;
                    }
        }
        else
            if (toCurrency === "EURO") {
                if (currency === "EURO") {
                    amount = amount;
                }
                else
                    if (currency === "USD") {
                        amount = amount * 0.91;
                    }
                    else
                        if (currency === "Rupees") {
                            amount = amount * 0.012;
                        }
            }

    return amount;
}
