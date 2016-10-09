package org.gagan.sap.messanger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gagan.sap.messanger.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionWrapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage=new ErrorMessage(404, exception.getMessage(), "No Data found");
		return Response.status(Status.NOT_FOUND)
				        .entity(errorMessage)
				        .build();
	}

}
