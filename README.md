# Microservices Patterns — Practice Pad

A hands‑on, production‑minded playground to master **Spring Boot + Docker + Kubernetes** microservice patterns:

* **SAGA (choreography & orchestration)**
* **CQRS + Event Sourcing**
* **API Gateway**
* **Service Discovery**
* Outbox / Transactional Messaging
* Idempotency + Retries + Circuit Breakers
* Distributed Tracing & Observability
* Config Server, Secrets, and Feature Flags

> Goal: Learn by building. Each pattern lives in a small, focused module with runnable examples, tests, and docs.

---

## Repo Map (initial)

```
microservices-patterns-practice-pad/
├─ README.md
├─ .gitignore
├─ LICENSE
├─ .github/
│  ├─ workflows/
│  │  └─ ci.yml
│  └─ ISSUE_TEMPLATE/
│     ├─ bug_report.md
│     └─ feature_request.md
├─ docs/
│  ├─ architecture-diagrams/
│  └─ notes/
├─ tooling/
│  ├─ docker/
│  ├─ k8s/
│  └─ scripts/
└─ patterns/
   ├─ saga/
   │  ├─ choreography/
   │  └─ orchestration/
   ├─ cqrs/
   │  ├─ command-service/
   │  └─ query-service/
   ├─ gateway/
   ├─ discovery/
   ├─ outbox/
   └─ tracing/
```

---

## Tech Stack

* **Java 21**, **Spring Boot 3.x**, **Spring Cloud 2024.x**
* **Maven** multi-module
* **Docker / Docker Compose** for local orchestration
* **Kubernetes** (Kind/Minikube) manifests and Helm (later)
* **PostgreSQL**, **Kafka** (or Redpanda), **Redis**
* **OpenTelemetry** + Grafana Tempo/Prometheus/Loki (later)

---

## How to Run (Quick Start)

1. Clone & build:

   ```bash
   mvn -q -DskipTests package
   ```
2. Boot a local stack (Compose):

   ```bash
   docker compose -f tooling/docker/compose.core.yml up -d
   ```
3. Run a pattern module (example — SAGA choreography):

   ```bash
   mvn -pl patterns/saga/choreography -am spring-boot:run
   ```

---

## Learning Mode

Each module includes:

* Minimal domain (Orders/Payments/Inventory)
* API contracts (OpenAPI)
* Step-by-step READMEs
* Test scenarios (happy path + failure)
* Troubleshooting cookbook

---

## Conventions

* Package names: `com.practicepad.<pattern>.<module>`
* Profiles: `dev`, `test`, `k8s`
* Observability: OpenTelemetry auto-instrumentation enabled via env vars
* Config: `tooling/config-repo` (Git-backed) for Spring Cloud Config

---

## Roadmap

* [ ] Pattern skeletons & smoke tests
* [ ] Compose: Postgres + Kafka + Zipkin
* [ ] SAGA: choreography (domain events) ✅ skeleton
* [ ] SAGA: orchestration (Orchestration Service)
* [ ] CQRS: split write/read services + ES
* [ ] Gateway: Spring Cloud Gateway + JWT
* [ ] Discovery: Eureka (local) → Kubernetes Service DNS
* [ ] Outbox: Debezium or polling publisher
* [ ] Tracing: OTel + Tempo/Jaeger
* [ ] Helm charts, Kind cluster e2e

---

## Branch Strategy

* `main`: stable examples
* `labs/*`: in-progress explorations per pattern
* Conventional commits + semantic version tags for big jumps

---

## License

MIT — do anything, keep the copyright notice.

---

## Credits

Created for deliberate, iterative practice. PRs welcome.
