
const students = [
    {
        usn: "1BI23CS001",
        name: "Rahul Sharma",
        semester: 7,
        subjects: [
            { name: "Software Testing", marks: 85 },
            { name: "Machine Learning", marks: 78 },
            { name: "Cloud Computing", marks: 91 },
            { name: "Web Technology", marks: 82 }
        ]
    },
    {
        usn: "1BI23CS002",
        name: "Priya Reddy",
        semester: 7,
        subjects: [
            { name: "Software Testing", marks: 72 },
            { name: "Machine Learning", marks: 88 },
            { name: "Cloud Computing", marks: 76 },
            { name: "Web Technology", marks: 90 }
        ]
    }
];

const form = document.getElementById("result-form");
const usnInput = document.getElementById("usn");
const message = document.getElementById("message");
const resultSection = document.getElementById("result-section");
const resultDetails = document.getElementById("result-details");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const usn = usnInput.value.trim().toUpperCase();

    // Clear previous results and messages
    message.textContent = "";
    resultSection.hidden = true;
    resultDetails.innerHTML = "";

    // Check for empty input
    if (usn === "") {
        message.textContent = "Please enter your USN.";
        return;
    }

    // Search for the student
    const student = students.find(function (item) {
        return item.usn === usn;
    });

    // Handle an unknown USN
    if (!student) {
        message.textContent = "No result found for this USN.";
        return;
    }

    // Calculate total and percentage
    const totalMarks = student.subjects.reduce(function (total, subject) {
        return total + subject.marks;
    }, 0);

    const maxMarks = student.subjects.length * 100;
    const percentage = (totalMarks / maxMarks) * 100;

    const status = student.subjects.every(function (subject) {
        return subject.marks >= 35;
    }) ? "PASS" : "FAIL";

    // Display student details
    resultDetails.innerHTML = `
        <p><strong>USN:</strong> ${student.usn}</p>
        <p><strong>Name:</strong> ${student.name}</p>
        <p><strong>Semester:</strong> ${student.semester}</p>
        <p><strong>Total Marks:</strong> ${totalMarks} / ${maxMarks}</p>
        <p><strong>Percentage:</strong> ${percentage.toFixed(2)}%</p>
        <p><strong>Result:</strong> <span id="result-status">${status}</span></p>

        <h3>Subject-wise Marks</h3>
        <table>
            <thead>
                <tr>
                    <th>Subject</th>
                    <th>Marks</th>
                </tr>
            </thead>
            <tbody>
                ${student.subjects.map(function (subject) {
                    return `
                        <tr>
                            <td>${subject.name}</td>
                            <td>${subject.marks}</td>
                        </tr>
                    `;
                }).join("")}
            </tbody>
        </table>
    `;

    message.textContent = "Result retrieved successfully.";
    resultSection.hidden = false;
});
