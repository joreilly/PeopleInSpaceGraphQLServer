PeopleInSpace GraphQL Server
---------------------------------

## Run Locally:
1. Start the local server: `./gradlew bootRun`
1. (Optional) To enable auto-reload, in another terminal / shell: `./gradlew -t classes`
1. Open: [localhost:8080/playground](http://localhost:8080/playground)

## Run on Google Cloud Run (with the command line):

1. [Install & setup gcloud](https://cloud.google.com/sdk/install)

1. Enable the Container, Container Registry, Cloud Build, and Cloud Run APIs:
    ```
    gcloud services enable container.googleapis.com containerregistry.googleapis.com cloudbuild.googleapis.com run.googleapis.com
    ```

1. Build the container image on Cloud Build using Buildpacks, storing the image on Google Container Registry:
    ```
    export PROJECT_ID=YOUR_GCP_PROJECT_ID
    gcloud builds submit --pack=image=gcr.io/$PROJECT_ID/peopleinspace-graphql
    ```

1. Deploy on Google Cloud Run:
    ```
    gcloud run deploy \
      --image=gcr.io/$PROJECT_ID/peopleinspace-graphql \
      --platform=managed \
      --allow-unauthenticated \
      --project=$PROJECT_ID \
      --region=us-central1 \
      --memory=1Gi \
      peopleinspace-graphql
    ```

## Local Docker Build & Run

1. [Install Docker](https://docs.docker.com/get-docker/)

1. Build the image
    ```
    ./gradlew bootBuildImage --imageName=peopleinspace-graphql
    ```

1. Run image:
    ```
    docker run -p8080:8080 peopleinspace-graphql
    ```

1. Open: [localhost:8080/playground](http://localhost:8080/playground)
