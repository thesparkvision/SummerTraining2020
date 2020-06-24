/* Function to get all the elements on loading of body */
function init()
{
    student_list=[]
    city_type="Dewas"
    roll=document.getElementById("roll")
    studentName=document.getElementById("name")
    branch=document.getElementById("branch")
    counter=document.getElementById("student-counter")
    studentTable=document.getElementById("student-table")
    messageBox=document.getElementById("op-message")
}

/* Function to change the city type when a radio button is selected */
function changeCity(city)
{
    city_type=city
}

/* Function to save the student data along with validating input */
function saveStudentData()
{
    var a=roll.value
    var b=studentName.value
    var c=branch.value
    var d=city_type
    isPresent=false

    //Checking if select box option is selected or not
    if(c=="")
    {
        messageBox.innerHTML="Please select a Branch from DropDown List!!!"
        return
    }

    //Checking if roll number is already present or not
    for(x=0;x<student_list.length;x++)
        if(student_list[x].roll==a)
        {
            isPresent=true
            messageBox.style.color="red";
            messageBox.innerHTML="Roll No. "+a+" Already exist!!!!"
            return
        }
    
    var student={roll:a,name:b,branch:c,city:d}
    student_list.push(student)
    counter.innerHTML="Number of Students:"+student_list.length
    messageBox.style.color="green";
    messageBox.innerHTML="Roll No. "+a+" Successfully added!"
}

/* Function to display the table of student details */
function showStudents()
{
    //Constructing header of table
    var table="<tr>"
    table+="<th>S.No.</th>"
    table+="<th>Roll No.</th>"
    table+="<th>Student Name</th>"
    table+="<th>Branch</th>"
    table+="<th>City</th>"
    table+="<th>Operation</th>"
    table+="</tr>"

    for(x=0;x<student_list.length;x++)
    {
        //Constructing rows of table
        student=student_list[x]
        var row="<tr>"
        row+="<td>"+(x+1)+"</td>"
        row+="<td>"+student.roll+"</td>"
        row+="<td>"+student.name+"</td>"
        row+="<td>"+student.branch+"</td>"
        row+="<td>"+student.city+"</td>"
        row+="<td><button class='form' onclick='deleteStudent("+x+")'>Delete</button></td>"
        row+="</tr>"
        table+=row
    }

    studentTable.innerHTML=table
}

/* Function to delete a particular student and update the counter */
function deleteStudent(id)
{
    student_list.splice(id,1)
    counter.innerHTML="Number of Students: "+student_list.length
    showStudents()
}