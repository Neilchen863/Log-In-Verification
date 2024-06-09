# Shadow Comrade

**Designed for Orbital24 by Hu Tongyan and Chen Jiahao**

## Motivation

### Current Issues:
1. **Reddit Limitations:**
   - NUS students primarily use the subreddit r/nus for school-related news and discussions.
   - Reddit does not support anonymous posting and commenting, limiting privacy.

2. **Inefficiency of Telegram:**
   - Students use Telegram group chats to find course partners or field trip buddies.
   - This process is inefficient and inconvenient.

### Solution:
- Create a dedicated platform for NUS students to communicate anonymously and find partners for various activities.

## Aim

To develop an online anonymous community with two main sections:
1. **Anonymous Treehole:**
   - A section for students to post about school-related topics or personal feelings anonymously.

2. **Partner Finding Section:**
   - A section for students to post or search for partners for activities such as studying, field trips, or course projects.

## User Stories

1. **Anonymous Inquiry/Discussion:**
   - As a student wanting to post inquiries or discussions anonymously, I want a secure and private platform where my identity is protected.
   
2. **Finding Suitable Partners:**
   - As a student looking for suitable study or project partners, I want a dedicated section to find partners efficiently without relying on traditional social media.

## Features

### Core Features:
1. **Anonymity:**
   - Protect user privacy by ensuring their information (especially school email used for verification) is hidden from everyone, including backend administrators.

2. **Searching Mechanism:**
   - Implement a tree-like structure for events, making it easier for users to find partners for specific needs.

3. **UI Design:**
   - Develop and decorate the main website and its branches for an intuitive user experience.

4. **Posting Mechanism:**
   - Allow users to post and comment anonymously.

### Extension Features:
1. **Reporting Mechanism:**
   - Enable users to report illegal or inappropriate content.

2. **User Homepage:**
   - Allow users to create a personalized homepage with key information while adhering to privacy policies.

## Tech Stack

1. **Web and UI Design:**
   - Focus on an intuitive and adaptive design to ensure the website functions well on both desktop and mobile devices.

2. **User Registration:**
   - Implement a secure registration process to verify NUS students while maintaining anonymity.

3. **Adaptive Design:**
   - Ensure the website adapts to various screen sizes and devices for a seamless user experience.

## Next Steps in milestone 2 & 3

1. **Develop a detailed project plan including timelines and milestones.**
2. **Design wireframes and prototypes for the UI/UX.**
3. **Set up a development environment and begin coding the core features.**
4. **Test the platform rigorously for security, anonymity, and usability.**
5. **Gather feedback from a small group of users and iterate on the design and functionality.**
6. **Launch the platform and continuously monitor and improve based on user feedback and emerging needs.**


## To test/run the app

1. For backend, the dependencies are managed by Maven, and detailed dependecies are as follows: Spring web, JDBC API, Spring Data JPA, MySQL Driver,
   which are also listed in pom.xml. And the environment is Java 21.
   
2. For frontend, after importing the project, first run "yarn install" to complete the project set up, then run "yarn run build".

3. For database, please modify springboot-login-demo/src/main/resources/application.properties. Create a local database and set the url, username
   and password in the file to point to the local database.

   
---
Feel free to contribute to the project by forking this repository and creating pull requests. For any questions or issues, please open an issue in the repository.
