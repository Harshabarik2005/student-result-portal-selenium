# Student Result Portal — Selenium Automation

## Overview
A web-based Student Result Portal with automated UI testing using Selenium WebDriver, Java, TestNG, Maven, and Jenkins.

## Features
- Search student results using USN.
- Display student details and subject marks.
- Validate invalid and empty search inputs.
- Automated browser testing using Selenium WebDriver.
- Test execution and dependency management using Maven and TestNG.
- Jenkins CI integration with published HTML test reports.

## Technologies Used
- Frontend: HTML, CSS, JavaScript
- Automation: Java, Selenium WebDriver, TestNG
- Build Tool: Maven
- CI: Jenkins
- Version Control: Git and GitHub

## Test Scenarios
- Valid USN search
- Invalid USN search
- Empty search input

## Test Results
The Jenkins pipeline currently executes three Selenium test methods successfully and publishes the TestNG HTML report.

## Project Structure
- `student-result-portal/` — web application
- `student-result-portal-testing/` — Selenium automation tests and Maven configuration

## Running the Tests
1. Start Jenkins or a local HTTP server for the portal.
2. Run the Maven tests from `student-result-portal-testing/` using `mvn test`.
3. View the generated reports in `target/surefire-reports/`.

## CI Pipeline
GitHub push events trigger Jenkins through a configured webhook. Jenkins starts the portal server, executes Selenium tests, and publishes the HTML test report.
