
import { authService } from './authService.js';
import { axiosx } from './axiosx.js';

const BASE_URL = authService.getBaseUrl();

class JobStageService {

    getJobStageList(){
        return axiosx.get(BASE_URL + '/jobStages', authService.getHttpOptions());
    }

    getJobStage(jobStage){
        return axiosx.get(BASE_URL + `/jobStages/${jobStage}`, authService.getHttpOptions());
    }

    addJobStage(jobStage){
        //validation
        if(jobStage.jobStage === ''){
            return Promise.reject('Job Stage is required');
        }

        jobStage.userCrt = authService.getAppUser();
        return axiosx.post(BASE_URL + '/jobStages', jobStage, authService.getHttpOptions());
    }

    updateJobStage(jobStage){
        jobStage.userMod = authService.getAppUser();
        return axiosx.put(BASE_URL + `/jobStages/${jobStage.jobStage}`, jobStage, authService.getHttpOptions());
    }

    deleteJobStage(jobStage){
        return axiosx.delete(BASE_URL + `/jobStages/${jobStage}`, authService.getHttpOptions());
    }
}

export let jobStageService = new JobStageService();
