package com.example.castlerockassociates.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignsData {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("agencyName")
    @Expose
    private String agencyName;
    @SerializedName("agencyId")
    @Expose
    private String agencyId;
    @SerializedName("idForDisplay")
    @Expose
    private String idForDisplay;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("display")
    @Expose
    private DisplayModel display;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getIdForDisplay() {
        return idForDisplay;
    }

    public void setIdForDisplay(String idForDisplay) {
        this.idForDisplay = idForDisplay;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DisplayModel getDisplay() {
        return display;
    }

    public void setDisplay(DisplayModel display) {
        this.display = display;
    }



    public class Location {

        @SerializedName("cityReference")
        @Expose
        private String cityReference;
        @SerializedName("locationDescription")
        @Expose
        private String locationDescription;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("routeId")
        @Expose
        private String routeId;
        @SerializedName("linearReference")
        @Expose
        private Double linearReference;
        @SerializedName("fips")
        @Expose
        private String fips;
        @SerializedName("perpendicularRadiansForDirectionOfTravel")
        @Expose
        private Double perpendicularRadiansForDirectionOfTravel;
        @SerializedName("signFacingDirection")
        @Expose
        private String signFacingDirection;

        public String getCityReference() {
            return cityReference;
        }

        public void setCityReference(String cityReference) {
            this.cityReference = cityReference;
        }

        public String getLocationDescription() {
            return locationDescription;
        }

        public void setLocationDescription(String locationDescription) {
            this.locationDescription = locationDescription;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getRouteId() {
            return routeId;
        }

        public void setRouteId(String routeId) {
            this.routeId = routeId;
        }

        public Double getLinearReference() {
            return linearReference;
        }

        public void setLinearReference(Double linearReference) {
            this.linearReference = linearReference;
        }

        public String getFips() {
            return fips;
        }

        public void setFips(String fips) {
            this.fips = fips;
        }

        public Double getPerpendicularRadiansForDirectionOfTravel() {
            return perpendicularRadiansForDirectionOfTravel;
        }

        public void setPerpendicularRadiansForDirectionOfTravel(Double perpendicularRadiansForDirectionOfTravel) {
            this.perpendicularRadiansForDirectionOfTravel = perpendicularRadiansForDirectionOfTravel;
        }

        public String getSignFacingDirection() {
            return signFacingDirection;
        }

        public void setSignFacingDirection(String signFacingDirection) {
            this.signFacingDirection = signFacingDirection;
        }

    }

    public class Properties {

        @SerializedName("maxSignPhases")
        @Expose
        private String maxSignPhases;
        @SerializedName("phaseDwellTime")
        @Expose
        private String phaseDwellTime;
        @SerializedName("phaseBlankTime")
        @Expose
        private String phaseBlankTime;
        @SerializedName("maxLinesPerPage")
        @Expose
        private String maxLinesPerPage;
        @SerializedName("maxCharactersPerLine")
        @Expose
        private String maxCharactersPerLine;
        @SerializedName("sizeKnown")
        @Expose
        private Boolean sizeKnown;

        public String getMaxSignPhases() {
            return maxSignPhases;
        }

        public void setMaxSignPhases(String maxSignPhases) {
            this.maxSignPhases = maxSignPhases;
        }

        public String getPhaseDwellTime() {
            return phaseDwellTime;
        }

        public void setPhaseDwellTime(String phaseDwellTime) {
            this.phaseDwellTime = phaseDwellTime;
        }

        public String getPhaseBlankTime() {
            return phaseBlankTime;
        }

        public void setPhaseBlankTime(String phaseBlankTime) {
            this.phaseBlankTime = phaseBlankTime;
        }

        public String getMaxLinesPerPage() {
            return maxLinesPerPage;
        }

        public void setMaxLinesPerPage(String maxLinesPerPage) {
            this.maxLinesPerPage = maxLinesPerPage;
        }

        public String getMaxCharactersPerLine() {
            return maxCharactersPerLine;
        }

        public void setMaxCharactersPerLine(String maxCharactersPerLine) {
            this.maxCharactersPerLine = maxCharactersPerLine;
        }

        public Boolean getSizeKnown() {
            return sizeKnown;
        }

        public void setSizeKnown(Boolean sizeKnown) {
            this.sizeKnown = sizeKnown;
        }

    }
}