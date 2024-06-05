<template>
  <div>
    <el-card class="box-card">
      <h2>Register</h2>
      <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-position="left"
          label-width="80px"
          class="demo-ruleForm"
      >
        <el-form-item label="Username" prop="uname">
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="pass">
          <el-input
              type="password"
              v-model="ruleForm.pass"
              autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="Confirm Password" prop="password">
          <el-input
              type="password"
              v-model="ruleForm.password"
              autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="btnGroup">
        <el-button type="primary" @click="submitForm('ruleForm')"  v-loading="loading"
        >Submit</el-button
        >
        <el-button @click="resetForm('ruleForm')">Reset</el-button>
        <el-button @click="goBack">Back</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter your password"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter your password again"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("Password didn't match!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        uname: "",
        pass: "",
        password: "",
      },
      rules: {
        uname: [
          { required: true, message: "Username cannot be empty!", trigger: "blur" },
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],
        password: [
          { required: true, validator: validatePass2, trigger: "blur" },
        ],
      },
      loading: false // Whether to show loading animation
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        this.loading = true;  // Show loading animation on submit button
        if (valid) {
          let _this = this;
          this.axios({     // axios makes a request to the backend
            url: "/api/user/register",  // Request URL
            method: "post",             // Request method
            headers: {                  // Request headers
              "Content-Type": "application/json",
            },
            data: { // Request parameters, use data, different from login's params
              uname: _this.ruleForm.uname,
              password: _this.ruleForm.password,
            },
          }).then((res) => { // Execute the code inside this block when the backend response is received. 'res' is the response information returned by the backend.
            if (res.data.code === '0') {  // When the response code is 0, registration is successful
              // Display the success message returned by the backend
              this.$message({
                message: res.data.msg,
                type: "success",
              });
            } else {  // When the response code is not 0, registration failed
              // Display the failure message returned by the backend
              this.$message({
                message: res.data.msg,
                type: "warning",
              });
            }
            // Whether the response is successful or failed, stop showing the loading animation on the submit button after receiving the backend response
            _this.loading = false;
            console.log(res);
          });
        } else { // If either username or password is not filled in, directly show the required prompt without making a request to the backend
          console.log("error submit!!");
          this.loading = false;
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style>
/* Set the registration panel to be centered, with a width of 400px */
.box-card {
  margin: auto auto;
  width: 400px;
}

/* Center the form within the registration panel */
.login-from {
  margin: auto auto;
}

body {
  background: linear-gradient(to right, #dab37c, #d193da); /* Set gradient background color */
  height: 100vh; /* Set height to viewport height */
  display: flex; /* Use flex layout */
  justify-content: center; /* Center horizontally */
  align-items: center; /* Center vertically */
  margin: 0; /* Remove default body margin */
}
</style>
