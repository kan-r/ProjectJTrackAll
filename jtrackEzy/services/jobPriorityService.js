import { authService } from './authService.js';
import { axiosx } from './axiosx.js';

const BASE_URL = authService.getBaseUrl();

class JobPriorityService {

    getJobPriorityList(){
        return axiosx.get(BASE_URL + '/jobPriority', authService.getHttpOptions());
    }

    getJobPriority(jobPriority){
        return axiosx.get(BASE_URL + `/jobPriority/${jobPriority}`, authService.getHttpOptions());
    }

    addJobPriority(jobPriority){
        //validation
        if(jobPriority.jobPriority === ''){
            return Promise.reject('Job Priority is required');
        }

        jobPriority.userCrt = authService.getAppUser();
        return axiosx.post(BASE_URL + '/jobPriority', jobPriority, authService.getHttpOptions());
    }

    updateJobPriority(jobPriority){
        jobPriority.userMod = authService.getAppUser();
        return axiosx.put(BASE_URL + '/jobPriority', jobPriority, authService.getHttpOptions());
    }

    deleteJobPriority(jobPriority){
        return axiosx.delete(BASE_URL + `/jobPriority/${jobPriority}`, authService.getHttpOptions());
    }
}

export let jobPriorityService = new JobPriorityService();
