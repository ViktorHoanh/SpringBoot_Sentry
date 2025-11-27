# Spring Boot + Sentry
====================

# Purpose
-------
Centralized error tracking, performance monitoring (APM), and structured logging for Spring Boot applications using Sentry (https://sentry.io).

## 1. Add Dependency
-----------------
Maven (pom.xml):

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>io.sentry</groupId>
            <artifactId>sentry-bom</artifactId>
            <version>${sentry.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

## 2. Configuration (application.properties)
-----------------------------------------

spring.application.name=SpringBootSentry

sentry.dsn=https://3043b4e0a4733df0d7b8e7b37b201c42@o4510420667269120.ingest.us.sentry.io/4510420709670912
sentry.in-app-includes=org.example.springbootsentry
sentry.send-default-pii=true
sentry.exception-resolver-order=-2147483647
sentry.traces-sample-rate=1.0
sentry.environment=development
sentry.release=spring-boot-sentry@1.0.0
sentry.logging.enabled=true
sentry.logging.minimum-event-level=INFO
sentry.logging.minimum-breadcrumb-level=DEBUG

## 3. What Sentry Automatically Provides
-------------------------------------
- All unhandled exceptions are automatically reported as Issues.
- All ERROR/WARN logs (and INFO logs if configured) become Sentry Events.
- Automatic Transactions and Spans for every HTTP request, including:
  - Database queries
  - External API calls
  - Application latency
- Automatic breadcrumbs from SLF4J/Logback.
- Automatic request data collection:
  - URL, HTTP method, headers, IP address, user-agent, etc.
