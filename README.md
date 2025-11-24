# 🏦 BankingTask – Selenium Test Automation Framework  
**A hybrid framework built using Java, TestNG, Selenium WebDriver, Apache POI (Excel), and Extent Reports.**  
It supports **parallel browser execution**, **modular page object design**, **data-driven testing**, and **rich HTML reports**.

---

## 🚀 Project Overview  

BankingTask is a test automation framework created to automate the Guru99 Banking application.  
The framework includes:

- 🧪 **Automated tests** for Login, New Customer, New Account, and Registration pages  
- 📄 **Data-driven testing using Excel (Apache POI)**  
- 🔄 **Parallel execution using TestNG XML**  
- 📊 **Advanced Extent Reports with screenshots on failure**  
- 🧱 **Page Object Model (POM) design pattern**  
- ⚙️ **Reusable utilities: Browser factory, driver management, listeners, reporting**  

This framework demonstrates real-world automation practices similar to corporate QA/SDET projects.

---

## 🛠️ Tech Stack  

| Category | Technology |
|---------|------------|
| Language | **Java (JDK 21)** |
| Test Framework | **TestNG** |
| Automation Tool | **Selenium WebDriver 4** |
| Reporting | **Extent Reports 5** |
| Build Tool | **Maven** |
| Data Source | **Apache POI (Excel)** |
| Design Pattern | **Page Object Model (POM)** |
| CI/CD (Optional) | GitHub Actions / Jenkins |

---

## 📁 Folder Structure  

BankingTask/
│
├── src/main/java
│ └── utils/
│ ├── BrowserFactory.java
│ ├── Drivefactory.java
│ ├── ExcelUtils.java
│ ├── ExtentManager.java
│ ├── Reportmanager.java
│ └── TestListener.java
│
├── src/test/java
│ ├── Pages/
│ │ ├── LoginPage.java
│ │ ├── NewaccountPage.java
│ │ ├── NewCustomerPage.java
│ │ └── ParaBank_RegisterPage.java
│ │
│ └── tests/
│ ├── LoginTest.java
│ ├── NewaccountTest.java
│ ├── NewCustomerTest.java
│ ├── ParaBank_RegisterTest.java
│ └── RunAll.java
│
├── src/test/resources
│ └── testdata/
│ └── loginData.xlsx
│
├── extent-reports/
│ └── index.html (auto generated)
│
├── testng.xml
└── README.md



---

## ⚙️ Features  

### ✅ **1. Data-Driven Testing (Excel + Apache POI)**  
- Excel file:  

src/test/resources/testdata/loginData.xlsx
- Multiple username/password sets supported  
- Failed login attempts are handled gracefully  
- Each row = one test execution  

### Example Excel Sheet:

| username | password |
|----------|----------|
| mngr646782 | zwydyze |
| wronguser | wrongpass |

---

### ✅ **2. Parallel Execution (TestNG)**  
Your `testng.xml` enables multi-browser or multi-test parallel runs:

```xml
<suite name="MySuite" parallel="tests" thread-count="3">
  <listeners>
      <listener class-name="utils.TestListener" />
  </listeners>

  <test name="LoginTest">
      <classes>
          <class name="tests.LoginTest"/>
      </classes>
  </test>
</suite>

---
 ✅ 3. Extent Reports Integration

All test steps logged

Pass/Fail status with timestamps

Screenshots captured on failures

4. Page Object Model (POM)

Each screen/page has its own class under:
src/test/java/Pages/
This makes the code modular, readable, and maintainable.

✅ 5. Driver Factory for Multi-Thread Execution

Drivefactory ensures parallel test execution without WebDriver conflicts.


📝 Sample Log Output
[PASS] Login successful for: mngr646782  
[FAIL] Invalid credentials detected  
Screenshot saved: extent-reports/screenshots/testLoginFromExcel.png




📄 License

This project is open-source and free to use for learning and automation practice.

